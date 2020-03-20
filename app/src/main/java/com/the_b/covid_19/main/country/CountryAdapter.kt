package com.the_b.covid_19.main.country

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.the_b.covid_19.R
import com.the_b.covid_19.model.CountryItem
import org.jetbrains.anko.find

class CountryAdapter (private val context: Context, private val items: MutableList<CountryItem>, private val listener: (CountryItem)->Unit)
    :RecyclerView.Adapter<CountryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.item_country, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binItem(items[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val country: TextView = view.find(R.id.country_name)

        fun binItem(items: CountryItem, listener: (CountryItem) -> Unit){
            country.text = items.country
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}