package dev.proedva.androidassessmenteai.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.proedva.androidassessmenteai.feature_operators.data.repository.OperatorsRepositoryImpl
import dev.proedva.androidassessmenteai.feature_operators.domain.repository.OperatorsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class OperatorRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindOperatorsRepository(
        operatorsRepositoryImpl: OperatorsRepositoryImpl
    ) : OperatorsRepository
}