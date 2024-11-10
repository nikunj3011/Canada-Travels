package canadatravels.di

import android.content.Context
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import canadatravels.MainViewModel
import canadatravels.util.AD_ID
import canadatravels.util.PREFERENCE_NAME
import canadatravels.util.REFRESH_TIMEOUT
import canadatravels.util.RateLimiter
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import canadatravels.HomeViewModel
import canadatravels.api.ZZZGuidesService
import canadatravels.repository.HomeRepository
import canadatravels.ui.character.CharacterViewModel
import canadatravels.ui.characterdetail.CharacterDetailsViewModel
import canadatravels.ui.bangboos.BangbooViewModel
import canadatravels.ui.homedata.HomeDataViewModel
import canadatravels.ui.wengines.WEngineViewModel
import canadatravels.util.ZZZGuide_URL
import java.util.concurrent.TimeUnit

val appModule = module {

    factory {
        AdRequest.Builder().build()
    }

    single {
        AdLoader.Builder(androidContext(), AD_ID)
    }

    single {
        Retrofit.Builder()
            .baseUrl(ZZZGuide_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ZZZGuidesService::class.java)
    }

//    single {
//        val db = get<NewsDatabase>()
//        db.videosDao()
//    }

    single {
        androidContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    single {
        RateLimiter<String>(REFRESH_TIMEOUT, TimeUnit.MINUTES)
    }

    single {
        HomeRepository(get())
    }

    viewModel {
        HomeViewModel(get())
    }

    viewModel {
        BangbooViewModel(get())
    }

    viewModel {
        CharacterDetailsViewModel(get())
    }

    viewModel {
        HomeDataViewModel(get())
    }

    viewModel {
        CharacterViewModel(get())
    }

    viewModel {
        WEngineViewModel(get())
    }

    viewModel {
        MainViewModel()
    }

}