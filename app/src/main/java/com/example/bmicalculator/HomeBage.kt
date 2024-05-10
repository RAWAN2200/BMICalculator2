package com.example.bmicalculator


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun BMI_Calculator(navController: NavController) {
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "BMI Calculator",
            fontSize = 32.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(vertical = 20.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.bodymass),
                contentDescription = "Body Mass",
                modifier = Modifier.size(300.dp)
            )
        }

        Text(
            text = "Enter your Height and Weight:",
            fontSize = 20.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(vertical = 20.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            TextField(
                value = height,
                onValueChange = { height = it },
                label = { Text(text = "Height (cm)") }
            )

            TextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text(text = "Weight (kg)") }
            )
        }

        Button(
            onClick = {
                if (height.isNotEmpty() && weight.isNotEmpty()) {
                    val result = calculateBMI(height.toDouble(), weight.toDouble())
                    navController.navigate("ResultScreen/$result")
                }
            },
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color.DarkGray),
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            Text(text = "Calculate BMI")
        }
    }
}


private fun calculateBMI(height: Double, weight: Double): String {
    val bmi = weight / ((height / 100) * (height / 100))
    return "Your BMI Score is %.2f".format(bmi)
}

