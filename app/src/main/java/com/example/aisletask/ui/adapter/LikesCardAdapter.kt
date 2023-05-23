package com.example.aisletask.ui.adapter

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.aisletask.databinding.LikesCardBinding
import com.example.aisletask.model.LikeProfiles
import com.example.aisletask.util.loadImage

class LikesCardAdapter(private var list: List<LikeProfiles>) :
    RecyclerView.Adapter<LikesCardAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: LikesCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @RequiresApi(Build.VERSION_CODES.S)
        fun bindData(item: LikeProfiles) {
            binding.name.text = item.first_name
            binding.image.setRenderEffect(RenderEffect.createBlurEffect( 100F,100F,Shader.TileMode.MIRROR))
            binding.image.loadImage(item.avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LikesCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    fun updateList(likeProfilesList: List<LikeProfiles>) {
        list = likeProfilesList
        notifyDataSetChanged()
    }
}