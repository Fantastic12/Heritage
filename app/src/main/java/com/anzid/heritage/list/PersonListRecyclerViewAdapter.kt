package com.anzid.heritage.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anzid.core.AutoUpdatableAdapter
import com.anzid.heritage.R
import com.anzid.heritage.model.PersonModel
import kotlin.properties.Delegates

class PersonListRecyclerViewAdapter : RecyclerView.Adapter<PersonListRecyclerViewAdapter.ViewHolder>(), AutoUpdatableAdapter {

    private var persons: List<PersonModel> by Delegates.observable(emptyList()) { _, old, new -> autoNotify(old, new) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = persons.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(persons[position])

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(personModel: PersonModel) {
            with(itemView) {
                id = personModel.age
            }
        }
    }
}