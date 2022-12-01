package dev.proedva.androidassessmenteai.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.proedva.androidassessmenteai.core.DispatcherProvider
import dev.proedva.androidassessmenteai.feature_login.data.remote.LoginAPI
import dev.proedva.androidassessmenteai.feature_operators.data.remote.OperatorAPI
import dev.proedva.androidassessmenteai.feature_bookings.data.remote.OrderAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://airoceanos-stage.dxn-tech.com/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesLoginApi(): LoginAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoginAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesOperators(): OperatorAPI =
        Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OperatorAPI::class.java)

    @Provides
    @Singleton
    fun providesOrderApi() : OrderAPI =
        Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OrderAPI::class.java)

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }
}