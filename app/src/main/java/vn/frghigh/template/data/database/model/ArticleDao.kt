package vn.frghigh.template.data.database.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface ArticleDao {

//    Using arg0 is way around, some issue with kotlin gradle plugin
//    expecting fix in further releases
    @Query("SELECT * FROM t_article WHERE source = :source")
    fun getArticlesBySource(source: String): LiveData<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addArticle(articleList: List<ArticleEntity>)

    @Delete
    fun deleteArticle(articleList: List<ArticleEntity>)

}