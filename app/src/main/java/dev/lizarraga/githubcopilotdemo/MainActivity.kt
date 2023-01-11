package dev.lizarraga.githubcopilotdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.lizarraga.githubcopilotdemo.ui.theme.GitHubCopilotDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubCopilotDemoTheme {
                MainScreen()
            }
        }
    }

    // create a Speaker data class with a name, company and url image
    data class Speaker(val name: String, val company: String, val imageUrl: String)

    // create a list of speakers from OpenWebinars Company
    val speakers = listOf(
        Speaker("Gustavo Lizárraga", "OpenWebinars", "https://avatars.githubusercontent.com/u/1924390"),
        Speaker("Miguel Ángel de la Cruz", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("David Gómez", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("Miguel Ángel de la Cruz", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("David Gómez", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("Miguel Ángel de la Cruz", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("David Gómez", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("Miguel Ángel de la Cruz", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("David Gómez", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("Miguel Ángel de la Cruz", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("David Gómez", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("Miguel Ángel de la Cruz", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("David Gómez", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("Miguel Ángel de la Cruz", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"),
        Speaker("David Gómez", "OpenWebinars", "https://avatars.githubusercontent.com/u/1018545"))

    // create a SpeakerItem composable function
    @Composable
    fun SpeakerItem(speaker: Speaker) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            elevation = 8.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // add AsyncImage from Coil
                AsyncImage(
                    model = speaker.imageUrl,
                    contentDescription = "speaker image",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(70.dp)
                        .clip(CircleShape),
                )
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = speaker.name, style = MaterialTheme.typography.h6)
                    Text(text = speaker.company, style = MaterialTheme.typography.subtitle2)
                }
            }
        }
    }

    // add MainScreen composable
    @Composable
    fun MainScreen() {
        // add Scaffold with TopAppBar
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("GitHub Copilot Demo") })
            }
        ) {
            LazyColumn {
                items(speakers) { speaker ->
                    SpeakerItem(speaker = speaker)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        GitHubCopilotDemoTheme {
            MainScreen()
        }
    }

}

