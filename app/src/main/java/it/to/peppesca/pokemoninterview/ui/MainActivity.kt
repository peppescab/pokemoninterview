package it.to.peppesca.pokemoninterview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import it.to.peppesca.pokemoninterview.R

/**
 * Entry point activity of the application
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_PokemonInterview)
        setContentView(R.layout.activity_main)
    }
}
