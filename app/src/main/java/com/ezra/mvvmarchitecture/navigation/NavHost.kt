package com.ezra.mvvmarchitecture.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ezra.mvvmarchitecture.ui.theme.about.About
import com.ezra.mvvmarchitecture.ui.theme.home.Home

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_HOME
){

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){

        composable(ROUTE_HOME){
            Home(navController)
        }

        composable(ROUTE_ABOUT){
            About(navController = navController)
        }







    }


}