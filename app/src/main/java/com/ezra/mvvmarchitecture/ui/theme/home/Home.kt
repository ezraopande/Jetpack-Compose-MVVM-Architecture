package com.ezra.mvvmarchitecture.ui.theme.home

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ezra.mvvmarchitecture.R
import com.ezra.mvvmarchitecture.navigation.ROUTE_ABOUT
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController) {
    var showFAB by remember { mutableStateOf(false) }
    val selectedIndex = remember { mutableStateOf(0) }

    val images = listOf(
        R.drawable.logo,
        R.drawable.logo,
        R.drawable.logo
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Home") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Home, contentDescription = "")
                    }
                },
                modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars)
            )
        },
        content = { paddingValues ->
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()

                ) {
                    // slider goes here
                    ImageSlider(images = images, imageWidth = 300.dp)


                    Text(text = "Home Screen")

                    Text(
                        text = "Go to about",
                        modifier = Modifier
                            .clickable { navController.navigate(ROUTE_ABOUT) }
                            .padding(top = 16.dp)
                    )







                }

                if (showFAB) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(bottom = 72.dp, end = 16.dp)
                            .windowInsetsPadding(WindowInsets.systemBars),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FloatingActionButton(onClick = { navController.navigate(ROUTE_ABOUT) }) {
                            Icon(Icons.Default.Add, contentDescription = "Action 1")
                        }
                        FloatingActionButton(onClick = { /* TODO: Handle action 2 */ }) {
                            Icon(Icons.Default.Edit, contentDescription = "Action 2")
                        }
                        FloatingActionButton(onClick = { /* TODO: Handle action 3 */ }) {
                            Icon(Icons.Default.Delete, contentDescription = "Action 3")
                        }
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigation(
                elevation = 10.dp,
                modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars)
            ) {

                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "") },
                    label = { Text(text = "Home") },
                    selected = (selectedIndex.value == 0),
                    onClick = {
                        showFAB = !showFAB
                        selectedIndex.value = 0
                    }
                )

                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "") },
                    label = { Text(text = "Favorite") },
                    selected = (selectedIndex.value == 1),
                    onClick = {
                        showFAB = false
                        selectedIndex.value = 1
                    }
                )

                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
                    label = { Text(text = "Profile") },
                    selected = (selectedIndex.value == 2),
                    onClick = {
                        navController.navigate(ROUTE_ABOUT)
                        showFAB = false
                        selectedIndex.value = 2
                    }
                )
            }
        }
    )
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(images: List<Int>, imageWidth: Dp = 300.dp) {
    val pagerState = rememberPagerState(pageCount = { images.size })
    val coroutineScope = rememberCoroutineScope()

    // Automatically change the visible image
    LaunchedEffect(pagerState.currentPage) {
        while (true) {
            delay(3000) // Change image every 3 seconds
            coroutineScope.launch {
                pagerState.animateScrollToPage((pagerState.currentPage + 1) % images.size)
            }
        }
    }

    // Animation for smooth transition
    val offset by animateFloatAsState(
        targetValue = pagerState.currentPage.toFloat(),
        animationSpec = tween(durationMillis = 600)
    )

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) { page ->
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = "Slider Image",
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .graphicsLayer {
                    val pageOffset = (pagerState.currentPage - page).toFloat()
                    val scale = 1f - (pageOffset * 0.2f).coerceIn(0f, 0.2f)
                    scaleX = scale
                    scaleY = scale
                    alpha = 1 - (pageOffset * 0.5f).coerceIn(0f, 0.5f)
                },
            contentScale = ContentScale.Crop
        )
    }
}