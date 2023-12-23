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
    
    @StateValue
    private var dialogSlot: ChildSlot<AnyObject, RootComponentChildDialog>
    
    init(_ component: RootComponent) {
        self.component = component
        _dialogSlot = StateValue(component.dialogSlot)
    }
    var body: some View {
        let isPresent = Binding(get: { dialogSlot.child?.instance != nil }, set: {_ in})
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
        ).alert(
            isPresented: isPresent,
            content: createAlert
        )
    }
    
    func createAlert() -> Alert{
        switch dialogSlot.child?.instance {
        case let slot as RootComponentChildDialogMessage: return MessageDialog(slot.component)
        default: return Alert(title: Text("Error"))
        }
    }
}

