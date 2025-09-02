package com.example.yogadaily.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yogadaily.data.model.Asana

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AsanaListScreen(asanas: List<Asana>, onAsanaClick: (Int) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Yoga Daily") }) }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(asanas) { asana ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onAsanaClick(asana.id) }
                ) {
                    Row(modifier = Modifier.padding(8.dp)) {
                        Image(
                            painter = painterResource(asana.image),
                            contentDescription = asana.title,
                            modifier = Modifier.size(80.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(text = "Day ${asana.day}: ${asana.title}", style = MaterialTheme.typography.titleMedium)
                            Text(text = "Difficulty: ${asana.difficulty}", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}
