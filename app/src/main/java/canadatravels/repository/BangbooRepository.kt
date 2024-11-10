package canadatravels.repository

import kotlinx.coroutines.flow.Flow
import canadatravels.models.db.Bangboo
import canadatravels.util.Resource

interface BangbooRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Bangboo>>>

    suspend fun getMovie(id: Int): Flow<Resource<Bangboo>>
}