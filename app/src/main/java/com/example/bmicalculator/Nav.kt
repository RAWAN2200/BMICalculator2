package com.example.bmicalculator

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Nav(){

    val navController = rememberNavController()
    NavHost(navController = navController  , startDestination = "BMI_CalculatorPage" ) {
   composable(route = "BMI_CalculatorPage"){
       BMI_Calculator(navController)
   }
        composable(route = "ResultScreen/{result}",
        arguments = listOf(
            navArgument(name = "result" ){
            type = NavType.StringType
            }
        )
        ){
//            ResultScreen(result = it.arguments?.getString("result"))
            ResultScreen(result = it.arguments?.getString("result") ?: "Default Result")

        }
    }
}