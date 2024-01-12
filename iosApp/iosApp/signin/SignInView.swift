//
//  SignInView.swift
//  iosApp
//
//  Created by Alisher on 23/12/23.
//

import SwiftUI
import shared

struct SignInView : View {
    private let component:SignInComponent
    
    @StateValue
    private var state:SignInState
    
    init(_ component: SignInComponent) {
        self.component = component
        _state = StateValue(component.state)
    }
    
    var body: some View{
        let email = Binding(get: { state.email }, set: component.onEmailTextChanged)
        let password = Binding(get: { state.password }, set: component.onPasswordTextChanged(text:))
        
        VStack{
            TextField("Email",text: email)
            TextField("Password",text: password)
            Button(action: component.onLogInClicked){
                Text("Log in")
            }
        }.padding()
    }
}
