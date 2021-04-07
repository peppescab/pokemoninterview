package it.to.peppesca.pokemoninterview.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import it.to.peppesca.pokemoninterview.R

/**
 * [setGlideSrc] set a source for an imageView with Glide.
 */
@BindingAdapter("android:glideSrc")
fun setGlideSrc(imageView: ImageView, url: String?) {
    url?.let {
        Glide.with(imageView)
            .load(url)
            .error(R.drawable.pokemon_placeholder)
            .into(imageView)
    }
}
