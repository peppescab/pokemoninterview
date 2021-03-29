package it.to.peppesca.pokemoninterview.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import it.to.peppesca.pokemoninterview.R

/**
 * [setPicassoSrc] set a source for an imageView with Picasso
 */
@BindingAdapter("android:glideSrc")
fun setPicassoSrc(imageView: ImageView, url: String?) {
    url?.let {
        Glide.with(imageView)
            .load(url)
            .placeholder(R.drawable.pokemon_placeholder)
            .into(imageView)
    }
}
