package com.example.roomdatabase.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.roomdatabase.data.User

@Composable
fun UserScreen(
    viewModel: UserViewModel = hiltViewModel()
) {

    var firstName by remember { mutableStateOf("") }
    var secondName by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }

    val users by viewModel.users.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = secondName,
            onValueChange = { secondName = it },
            label = { Text("Second Name") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = mail,
            onValueChange = { mail = it },
            label = { Text("Mail-id") }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {

                viewModel.insert(
                    firstName,
                    secondName,
                    age.toIntOrNull() ?: 0,
                    mail
                )

                firstName = ""
                secondName = ""
                age = ""
                mail = ""
            }
        ) {
            Text("Add User")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(users) { user ->

                UserRow(
                    user = user,
                    onDelete = {
                        viewModel.deleteUser(user)
                    },
                    onUpdate = {
                        viewModel.updateUser(
                            user.copy(
                                firstname = "Updated"
                            )
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun UserRow(
    user: User,
    onDelete: () -> Unit,
    onUpdate: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {

        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            Text(
                text = "${user.firstname} ${user.secondName}"
            )

            Text(
                text = "Age: ${user.age}"
            )

            Text(
                text = "Mail: ${user.mail}"
            )

            Row {

                Button(
                    onClick = onUpdate
                ) {
                    Text("Update")
                }

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Button(
                    onClick = onDelete
                ) {
                    Text("Delete")
                }
            }
        }
    }
}
