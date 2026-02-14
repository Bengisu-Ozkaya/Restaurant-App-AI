package com.example.restaurantappai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restaurantappai.ui.theme.RestaurantAppAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantAppAITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF5F5F5)
                ) {
                    SignUpScreen(
                        onLoginClick = {
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(
    onLoginClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .background(Color(0xFFF5F5F5)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        // ÜST GÖRSEL
        Image(
            painter = painterResource(id = R.drawable.illustration),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(24.dp))

        // BAŞLIK
        Text(
            text = "Sign up",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // EMAIL SATIRI
        /*Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.work),
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "itsnaeemanjum@gmail.com",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }*/

        CustomTextField(
            icon = R.drawable.work,
            placeholder = "Email"
        )

        CustomTextField(
            icon = R.drawable.profile,
            placeholder = "Fullname"
        )

        CustomTextField(
            icon = R.drawable.calling,
            placeholder = "Mobile"
        )

        CustomTextField(
            icon = R.drawable.password,
            placeholder = "Password",
            isPassword = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // TERMS TEXT
        Text(
            text = "By Signing up, you’re agree to our Term & Conditions and Privacy Policy",
            fontSize = 12.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // CONTINUE BUTTON
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF54D1B6)
            ),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
        ) {
            Text(
                text = "Continue",
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // LOGIN TEXT
        Row {
            Text(
                text = "Joined before? ",
                color = Color.Gray
            )
            Text(
                text = "Login",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.clickable(onClick = onLoginClick)
            )
        }
    }
}

@Composable
fun CustomTextField(
    icon: Int,
    placeholder: String,
    isPassword: Boolean = false
) {

    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = {
            Text(text = placeholder, color = Color.Gray)
        },
        leadingIcon = {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.Gray
            )
        },
        visualTransformation = if (isPassword)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        )
    )
}
