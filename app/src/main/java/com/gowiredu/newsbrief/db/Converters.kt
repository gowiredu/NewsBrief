package com.gowiredu.newsbrief.db

import androidx.room.TypeConverter
import com.gowiredu.newsbrief.models.Source

class Converters {

    // Convert source to string by taking name of the source.
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source (name, name)
    }




}