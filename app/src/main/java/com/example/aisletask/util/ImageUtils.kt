package com.example.aisletask.util

import android.widget.ImageView
import com.example.aisletask.R
import com.squareup.picasso.Picasso

fun ImageView.loadImage(imageUrl: String?) {
    imageUrl?.let {
        if (imageUrl.isNotEmpty())
            Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.image_placeholder)
                .error(R.drawable.image_placeholder).into(this)
        else
            this.setImageDrawable(resources.getDrawable(R.drawable.image_placeholder))
    } ?: this.setImageDrawable(resources.getDrawable(R.drawable.image_placeholder))
}

