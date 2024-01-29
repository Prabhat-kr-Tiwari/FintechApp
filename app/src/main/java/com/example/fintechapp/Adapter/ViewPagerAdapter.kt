package com.example.fintechapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fintechapp.Model.Contacts
import com.example.fintechapp.R
import com.google.android.material.textview.MaterialTextView

/*class ViewPagerAdapter {
}*/
class ViewPagerAdapter(private val context: Context, private val contactList: List<Contacts>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sends_money_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to your views for each page
        val contact = contactList[position]
        // Example: holder.imageView.setImageResource(contact.imageResId)
        // Example: holder.textView.text = contact.name
        holder.personImage.setImageResource(contact.image)
        holder.personName.text = contact.name
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personImage = itemView.findViewById<ImageView>(R.id.person_image)
        val personName = itemView.findViewById<MaterialTextView>(R.id.contacts_name)

    }
}
