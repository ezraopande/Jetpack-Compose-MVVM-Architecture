package com.ezra.mvvmarchitecture.ui.theme.about

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ezra.mvvmarchitecture.navigation.ROUTE_HOME

@Composable
fun About(navController: NavController){

    Text(text = "About Screen")
    Text(text = "Go to home",
        modifier = Modifier
            .clickable { navController.navigate(ROUTE_HOME) }
    )




}