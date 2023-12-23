package kaa.alisherbu.listbookstudio.shared.home

import com.arkivanov.decompose.ComponentContext
import kaa.alisherbu.listbookstudio.shared.home.HomeComponent.Output

class HomeComponentImpl internal constructor(
    componentContext: ComponentContext,
    private val output: (Output) -> Unit
) : HomeComponent, ComponentContext by componentContext {

}
