package com.example.shoppeclonee.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppeclonee.viewmodel.provider.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanRegister(
    onBack: () -> Unit,
    vm: AuthViewModel = viewModel()
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val roles = listOf("user", "seller")
    var selectedRole by remember { mutableStateOf("user") }
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopAppBarLokalku("Register") }
    ) { pad ->

        Box(
            modifier = Modifier
                .padding(pad)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(0.9f),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Text(
                        "Buat Akun Baru",
                        style = MaterialTheme.typography.titleLarge
                    )

                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )

                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded }
                    ) {
                        OutlinedTextField(
                            value = selectedRole,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Role") },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            roles.forEach {
                                DropdownMenuItem(
                                    text = { Text(it) },
                                    onClick = {
                                        selectedRole = it
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }

                    Button(
                        onClick = {
                            vm.register(
                                username = username,
                                email = email,
                                password = password,
                                role = selectedRole
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Daftar")
                    }

                    vm.message.value?.let {
                        Text(it, color = MaterialTheme.colorScheme.error)
                    }

                    TextButton(onClick = onBack) {
                        Text("Kembali ke Login")
                    }
                }
            }
        }
    }
}
