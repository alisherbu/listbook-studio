package kaa.alisherbu.listbook.feature.root.di

import dagger.Binds
import dagger.Module
import kaa.alisherbu.listbook.feature.root.component.RootComponent
import kaa.alisherbu.listbook.feature.root.component.RootComponentImpl
import kaa.alisherbu.listbook.feature.root.data.repository.RootRepositoryImpl
import kaa.alisherbu.listbook.feature.root.domain.repository.RootRepository
import kaa.alisherbu.listbook.feature.root.store.RootStore
import kaa.alisherbu.listbook.feature.root.store.RootStoreImpl

@Module
internal interface RootModuleBinds {

    @Binds
    fun componentFactory(impl: RootComponentImpl.Factory): RootComponent.Factory

    @Binds
    fun rootRepository(impl: RootRepositoryImpl): RootRepository

    @Binds
    fun rootStore(impl: RootStoreImpl): RootStore
}
