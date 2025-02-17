package com.example.ftinesstracker

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Fireplace
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ftinesstracker.ui.theme.FtinessTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            FitnessTrackerApp()

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessTrackerApp(){

    //Create a NAvController to manage navigation
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Fitness Tracker",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold)
                }
            )
        },
        content = { paddingValues ->
            //WelcomeScreen(Modifier.padding(paddingValues))
            FitnessNavHostController(
                navController = navController,
                modifier = Modifier.padding(paddingValues)
            )
        }

    )
}

@Composable
fun FitnessNavHostController(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "welcome_screen",
        modifier = modifier
    ){
        composable("welcome_screen"){ WelcomeScreen(navController) }
        composable("dashboard_screen"){ DashboardScreen() }
    }
}

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = "Fitness Dashboard",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.height(16.dp))
        //Steps Card
        FitnessStatCard(
            icon = Icons.Filled.DirectionsRun,
            title = "Steps",
            value = "10,000",
            color = Color(0xFF1E88E5)

        )
        Spacer(modifier = Modifier.height(16.dp))
        //Calories Card
        FitnessStatCard(
            icon = Icons.Filled.Fireplace,
            title = "Calories",
            value = "523kcal",
            color = Color(0xFFF4511E)

        )
        Spacer(modifier = Modifier.height(16.dp))
        //Workout time Card
        FitnessStatCard(
            icon = Icons.Filled.Timer,
            title = "Workout time",
            value = "45min",
            color = Color(0xFF43A047)

        )
    }
}

@Composable
fun WelcomeScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Welcome to Fitness Tracker!",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button( onClick = {
            navController.navigate("dashboard_screen")

        }){
            Text(text = "Go to Dashboard")
        }
    }
}

//Lets define some cards which show us the mock data of fitness
@Composable
fun FitnessStatCard(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, value: String, color: Color) {

    Card(
        modifier = Modifier.fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.5f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Icon
            Icon(
                imageVector = icon,
                contentDescription = "$title icon",
                tint = color,
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            //Data
            Column{
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    color = color
                )
              Text(
                  text = value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                  fontSize = 24.sp
              )
        }

        }
    }

}
