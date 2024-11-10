package canadatravels.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharactersDao {
    @Query("UPDATE categories SET isSelected = 1 WHERE id = :categoryId")
    suspend fun setSelectedCategory(categoryId: String)

    @Query("UPDATE categories SET isSelected = 0 WHERE id != :categoryId")
    suspend fun clearSelectedCategory(categoryId: String)

}