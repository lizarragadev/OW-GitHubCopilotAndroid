package dev.lizarraga.githubcopilotdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
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

    // add a list of speakers
    val speakers = listOf<Speaker>(
        Speaker("Gustavo Lizarraga", "Openwebinars", "https://avatars.githubusercontent.com/u/1018365?v=4"),
        Speaker("Juan Salgado", "Platzi", "https://avatars.githubusercontent.com/u/1018365?v=4"),
        Speaker("Pedro Lopez", "Google", "https://avatars.githubusercontent.com/u/1018365?v=4")
    )

    @Composable
    fun SpeakerItem(speaker: Speaker) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp, start = 8.dp, end = 8.dp),
            elevation = 6.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Row {
                // Add AsyncImage from Coil
                AsyncImage(
                    model = speaker.imageUrl,
                    contentDescription = "Speaker image",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                )
                // create a Column with the speaker name and company
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = speaker.name,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = speaker.company,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
    
    // add mainScreen composable
    @Composable
    fun MainScreen() {
        // add Scaffold with TopAppBar
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "GitHub Copilot Demo")
                    }
                )
            }
        ) {
            // add LazyColumn with speakers
            LazyColumn {
                items(speakers) { speaker ->
                    SpeakerItem(speaker = speaker)
                }
            }
        }

    }

}

