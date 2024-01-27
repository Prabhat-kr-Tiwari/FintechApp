package com.example.fintechapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fintechapp.Model.Transfer
import com.example.fintechapp.databinding.TransferItemBinding

class TransferAdapter
    (private val context: Context, private val list: List<Transfer>) :
    RecyclerView.Adapter<TransferAdapter.ViewHolder>() {

    inner class ViewHolder
        (private val binding: TransferItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val transferMode = binding.txtTransferMode
        val transferIcon = binding.transferIcon

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TransferItemBinding.inflate(
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
        holder.transferMode.text=model.transferMode
        Glide.with(context).load(model.transferIcon).into(holder.transferIcon)
    }
}