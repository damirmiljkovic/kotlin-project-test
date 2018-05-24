package net.alhazmy13.demoproject.di

import dagger.Module
import dagger.Provides
import net.alhazmy13.demoproject.BuildConfig
import net.alhazmy13.demoproject.network.Endpoints
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(@Named("loggingInterceptor") loggingInterceptor: Interceptor): OkHttpClient {
        val client = OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideEndpoints(httpClient: OkHttpClient): Endpoints {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Endpoints::class.java)
    }

    @Provides
    @Singleton
    @Named("loggingInterceptor")
    fun provideLoggingInterceptor():Interceptor{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        if (BuildConfig.DEBUG)
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }
}