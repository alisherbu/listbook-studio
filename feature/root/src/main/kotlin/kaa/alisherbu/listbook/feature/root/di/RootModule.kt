package kaa.alisherbu.listbook.feature.root.di

import dagger.Module
import dagger.Provides
import kaa.alisherbu.listbook.feature.root.domain.usecase.CheckUserSignedUseCase
import kaa.alisherbu.listbook.feature.root.store.RootExecutor

@Module(includes = [RootModuleBinds::class])
class RootModule {

    @Provides
    internal fun provideExecutor(checkUserSignedUseCase: CheckUserSignedUseCase): RootExecutor {
        return RootExecutor(checkUserSignedUseCase)
    }
}
