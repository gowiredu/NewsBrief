package com.gowiredu.newsbrief.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gowiredu.newsbrief.models.Article

@Dao
interface ArticleDao {
    // insert or update article in local database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles() : LiveData<List<Article>>

    // delete article in local database
    @Delete
    suspend fun deleteArticle(article: Article)
}