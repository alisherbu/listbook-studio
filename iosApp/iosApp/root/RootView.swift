//
//  RootView.swift
//  iosApp
//
//  Created by Alisher on 20/12/23.
//

import SwiftUI
import shared

struct RootView : View {
    let component:RootComponent
    init(_ component: RootComponent) {
        self.component = component
    }
    var body: some View {
        StackView(
            stackValue: StateValue(component.screenStack),
            onBack:component.onBackClicked,
            childContent: {
                switch $0 {
                case let child as RootComponentChildScreenMain: MainView(child.component)
                case let child as RootComponentChildScreenAuth: AuthView(child.component)
                case let child as RootComponentChildScreenSignIn: SignInView(child.component)
                case let child as RootComponentChildScreenSignup: SignupView(child.component)
                default: EmptyView()
                }
            }
        )
    }
}
