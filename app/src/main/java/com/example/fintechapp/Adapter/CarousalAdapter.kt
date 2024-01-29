package com.example.fintechapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fintechapp.Model.Contacts
import com.example.fintechapp.databinding.SendMoneyItemBinding
import com.example.fintechapp.databinding.SendsMoneyItemBinding
import com.example.fintechapp.databinding.TransactionsItemBinding


class CarousalAdapter(private val context: Context, private val list: List<Contacts>) :
    RecyclerView.Adapter<CarousalAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: SendsMoneyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val personImage = binding.personImage
        val personName = binding.contactsName
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SendsMoneyItemBinding.inflate
                (LayoutInflater.from(parent.context), parent, false)
        )
    }
    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contactsModel = list[position]
        Glide.with(context).load(contactsModel.image).into(holder.personImage)
        holder.personName.text = contactsModel.name
    }
}