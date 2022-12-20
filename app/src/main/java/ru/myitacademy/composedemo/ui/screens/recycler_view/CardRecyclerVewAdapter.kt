package ru.myitacademy.composedemo.ui.screens.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.myitacademy.composedemo.R
import ru.myitacademy.composedemo.data.Record

class CardRecyclerVewAdapter(
    var dataSet: List<Record>
): RecyclerView.Adapter<CardRecyclerVewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heading: TextView
        val supportText: TextView

        init {
            heading = itemView.findViewById(R.id.heading)
            supportText = itemView.findViewById(R.id.support)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.heading.text = dataSet[position].heading
        holder.supportText.text = dataSet[position].subtext
    }

    override fun getItemCount(): Int = dataSet.size
}