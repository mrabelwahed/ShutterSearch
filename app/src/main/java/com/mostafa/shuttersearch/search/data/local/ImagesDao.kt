package com.mostafa.shuttersearch.search.search.data.local

import androidx.paging.DataSource
import androidx.room.*
import com.mostafa.shuttersearch.search.search.model.AppImageModel

@Dao
interface ImagesDao {

    /***
     * Do a similar query as the search API
     * Look for images that contain the query string in the description
     */
    @Query("SELECT * FROM images WHERE searchQuery LIKE '%' || :query ||'%'")
    fun getImages(query: String): DataSource.Factory<Int, AppImageModel>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieList: List<AppImageModel>)

    @Query("DELETE FROM images")
    fun deleteAll()
}