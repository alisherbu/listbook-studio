//
//  SignInView.swift
//  iosApp
//
//  Created by Alisher on 23/12/23.
//

import SwiftUI
import shared

struct SignInView : View{
    private let component:SignInComponent
    
    @StateValue
    private var state:SignInState
        
    init(_ component: SignInComponent) {
        self.component = component
        _state = StateValue(component.state)
    }
    
    var body: some View{
        let email = Binding(get: { state.email }, set: component.onEmailTextChanged)

        TextField("Email",text: email)
    }
}
