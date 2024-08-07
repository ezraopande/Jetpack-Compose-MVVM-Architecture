package com.ezra.mvvmarchitecture.ui.theme.home

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ezra.mvvmarchitecture.navigation.ROUTE_ABOUT
import com.ezra.mvvmarchitecture.navigation.ROUTE_HOME

@Composable
fun Home(navController: NavController){

    Text(text = "Home Scree")

    Text(text = "Go to about",
        modifier = Modifier
            .clickable { navController.navigate(ROUTE_ABOUT) }
    )

}