package ru.myitacademy.composedemo.ui.screens.lazy_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.myitacademy.composedemo.R
import ru.myitacademy.composedemo.data.Record
import ru.myitacademy.composedemo.ui.MainViewModel

@Composable
fun LazyListScreen(
    mainViewModel: MainViewModel = viewModel()
) {

    val dataSet = mainViewModel.recordsState

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = dataSet
        ) { record ->
            Row {
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(R.drawable.ic_baseline_kayaking_24),
                    contentDescription = null
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = record.heading,
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = record.subtext
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                }
            }
        }
    }
}