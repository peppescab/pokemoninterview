package it.to.peppesca.data.injection

import it.to.peppesca.data.api.PokemonApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import java.util.*


private val loggingInterceptor      = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

const val POKEMON_URL = "https://pokeapi.co/api/v2/"

val serviceModule = module {


    single {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .baseUrl(POKEMON_URL)
           // .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(PokemonApi::class.java) }

}