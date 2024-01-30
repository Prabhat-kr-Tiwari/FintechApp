package com.example.fintechapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fintechapp.Model.Spend
import com.example.fintechapp.databinding.SpendItemBinding

class SpendAdapter
    (private val context: Context, private val list: List<Spend>) :
    RecyclerView.Adapter<SpendAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: SpendItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image = binding.image
        val price = binding.price
        val spendOn = binding.spendOnTxt

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SpendItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model=list[position]
        holder.spendOn.text=model.spendOn
        holder.price.text=model.price
        Glide.with(context).load(model.image).into(holder.image)
    }
}