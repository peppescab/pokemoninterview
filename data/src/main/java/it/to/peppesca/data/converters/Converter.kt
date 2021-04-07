package it.to.peppesca.data.converters

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

/**
 * Util class to convert a list of String.
 */
class Converter {
    private val moshi = Moshi.Builder().build()
    private val types = Types.newParameterizedType(List::class.java, String::class.java)
    private val typesAdapter = moshi.adapter<List<String>>(types)

    @TypeConverter
    fun stringToMembers(string: String): List<String> {
        return typesAdapter.fromJson(string).orEmpty()
    }

    @TypeConverter
    fun membersToString(members: List<String>): String {
        return typesAdapter.toJson(members)
    }
}