package net.iessochoa.sergiocontreras.poketinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.poketinder.model.Pokemon

@Composable
fun CapturesScreen(capturedPokemon: List<Pokemon>, onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onBack) {
            Text(text = "Volver")
        }
        LazyColumn {
            items(capturedPokemon) {
                Text(text = it.name, modifier = Modifier.padding(8.dp))
            }
        }
    }
}