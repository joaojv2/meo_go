package com.meo.go.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, poserPath: String) {
    Picasso.get().load(poserPath).into(view)

}