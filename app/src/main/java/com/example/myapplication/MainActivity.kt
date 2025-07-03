package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ItemListScreen(
                        viewModel = viewModel,
                        onItemClick = { itemName ->
                            val intent = Intent(this, DetailActivity::class.java).apply {
                                putExtra("item_name", itemName)
                            }
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ItemListScreen(viewModel: ItemViewModel, onItemClick: (String) -> Unit) {
    val items by viewModel.items

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 42.dp, start = 16.dp, end = 16.dp)
    ) {
        items(items) { item ->
            Text(
                text = item.name+" "+item.last_name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick("${item.name} ${item.last_name}") }
                    .padding(16.dp)
            )
            Divider()
        }
    }
}
