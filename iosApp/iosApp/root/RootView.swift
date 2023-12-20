//
//  RootView.swift
//  iosApp
//
//  Created by Alisher on 20/12/23.
//

import SwiftUI
import shared

struct RootView : View {
    let rootComponent:RootComponent
    init(_ rootComponent: RootComponent) {
        self.rootComponent = rootComponent
    }
    var body: some View {
        StackView(
            stackValue: StateValue(rootComponent.screenStack),
            onBack:rootComponent.onBackClicked,
            childContent: {
                switch $0 {
                case let child as RootComponentChildScreenMain: MainView(child.component)
                case let child as RootComponentChildScreenAuth: AuthView(child.component)
                default: EmptyView()
                }
            }
        )
    }
}
