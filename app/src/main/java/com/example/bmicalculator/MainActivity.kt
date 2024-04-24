package com.example.bmicalculator

import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import com.example.bmicalculator.ResultScreen
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.bmicalculator.ui.theme.BMICalculatorTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            BMI_Calculator("BMI ", 32)
            tow_text_Field()
                }
            }
        }


@Composable
fun BMI_Calculator(name: String , size: Int ) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray), verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = " ",
            fontSize = size.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(20.dp)
        )
        Text(
            text = " BMI Claculator",
            fontSize = 32.sp,
            color = Color.DarkGray,
//        modifier = Modifier.padding(20.dp)
        )
    }
    Row(
        ) {
        Image(
            painter = painterResource(id = R.drawable.bodymass), contentDescription = "",
            Modifier
                .fillMaxSize()
                .size(800.dp)
                .height(500.dp)
                .padding(start = 20.dp, end = 20.dp, bottom = 250.dp)
        )

    }
}

@Composable
fun tow_text_Field(){
    var Height  by remember { mutableStateOf("") }
    var Weidth by remember { mutableStateOf("") }
    var  result by remember { mutableStateOf("") }

       Column {
        Row() {

            TextField(
                value = Height ,
                onValueChange = {Height = it},
                label = { Text(text = "Height ") },
                modifier = Modifier
                    .padding(start = 90.dp, top = 400.dp)
                    .size(100.dp)
//                modifier = Modifier.padding(start = 250.dp).size(100.dp)
            )
            TextField(
                value = Weidth,
                onValueChange = {Weidth = it},
                label = { Text(text = "Weidth") },
                modifier = Modifier
                    .padding(start = 40.dp, top = 400.dp)
                    .size(100.dp)
            )
        }
    Button(onClick = {
        result = calculationResult(Height=Height.toDouble(), Weidth=Weidth.toDouble())
    } ,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color.DarkGray),
        modifier = Modifier.padding(start = 170.dp , bottom = 50.dp , top = 10.dp),
        colors = ButtonDefaults.buttonColors(Color(R.color.grr)),

        )
           {
        Text(text = "Result")
    }
           Text(
               text = result,
               modifier = Modifier.padding(start = 160.dp , bottom = 50.dp),
               color = Color.Black
           )
}
}


private fun calculationResult(Height:Double,Weidth:Double): String {
    val bmi = Weidth / (Height * Height)
    return "Yor BMI Score is $bmi"

}




