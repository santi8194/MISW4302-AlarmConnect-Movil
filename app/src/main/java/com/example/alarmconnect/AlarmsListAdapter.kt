package com.example.alarmconnect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmconnect.databinding.ListItemAlarmsBinding

class AlarmsListAdapter(private val items: List<AlarmsListItem>) :
    RecyclerView.Adapter<AlarmsListAdapter.HomeViewHolder>() {

    class HomeViewHolder(val binding: ListItemAlarmsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AlarmsListItem) {
            if (item.type == "section") {
               binding.priorityContainer.visibility = View.GONE
                binding.contactIcon.visibility = View.GONE
                binding.viewButton.visibility = View.GONE
                binding.itemDescription.visibility = View.GONE
            } else {
                binding.priorityContainer.visibility = View.VISIBLE
                binding.contactIcon.visibility = View.VISIBLE
                binding.viewButton.visibility = View.VISIBLE
                binding.itemDescription.visibility = View.VISIBLE
                binding.itemDescription.text = item.description
            }
            binding.itemTitle.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding =
            ListItemAlarmsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

data class AlarmsListItem(val title: String, val description: String, val type: String)