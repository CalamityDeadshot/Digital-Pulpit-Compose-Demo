package ru.myitacademy.composedemo.ui.screens.recycler_view

import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.myitacademy.composedemo.data.Record
import ru.myitacademy.composedemo.ui.MainViewModel

@Composable
fun RecyclerViewScreen(
    mainViewModel: MainViewModel = viewModel()
) {

    val dataSet = mainViewModel.recordsState
    val adapter = CardRecyclerVewAdapter(dataSet)

    AndroidView(
        factory = {
            RecyclerView(it).apply {
                layoutParams = RecyclerView.LayoutParams(
                    RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.MATCH_PARENT
                )
                setAdapter(adapter)
                layoutManager = LinearLayoutManager(it)
                visibility = View.VISIBLE
            }
        }
    ) {
        adapter.dataSet = dataSet
        adapter.notifyDataSetChanged()
    }
}