package kaa.alisherbu.listbookstudio.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kaa.alisherbu.listbook.feature.root.component.RootComponentImpl
import kaa.alisherbu.listbook.feature.root.di.RootModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RootModule::class,
    ]
)
interface AppComponent {
    val rootComponentFactory: RootComponentImpl.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}
