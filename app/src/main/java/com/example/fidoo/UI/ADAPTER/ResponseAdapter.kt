package com.example.fidoo.UI.ADAPTER

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fidoo.databinding.ItemLayoutBinding
import com.example.fidoo.DATA.Data

class ResponseAdapter(private val responseList : List<Data>) : RecyclerView.Adapter<ResponseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder {
        val itemLayoutBinding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ResponseViewHolder(itemLayoutBinding)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder:ResponseViewHolder, pos: Int) {
        val data = responseList[pos]
        holder.itemLayoutBinding.apply {
            tvId.text = "Id :- "+data.id
            tvUserId.text = "User Id :- "+data.userId
            tvTitle.text = "Title :- "+data.title
            tvBody.text = "Description :- "+data.body
        }
    }
    override fun getItemCount(): Int {
        return responseList.size
    }
}
class ResponseViewHolder(val itemLayoutBinding: ItemLayoutBinding) : RecyclerView.ViewHolder(itemLayoutBinding.root)