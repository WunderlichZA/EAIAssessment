package dev.proedva.androidassessmenteai.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.proedva.androidassessmenteai.feature_bookings.data.repository.OrderRepositoryImpl
import dev.proedva.androidassessmenteai.feature_bookings.domain.repository.OrderRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 abstract class OrderRepositoryModule {
     @Binds
     @Singleton
     abstract fun bindOrderRepository(
         orderRepositoryImpl: OrderRepositoryImpl
     ) : OrderRepository
 }