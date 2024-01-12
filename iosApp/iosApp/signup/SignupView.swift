//
//  SignupView.swift
//  iosApp
//
//  Created by Alisher on 23/12/23.
//

import SwiftUI
import shared

struct SignupView : View{
    private let component:SignupComponent
    
    @StateValue
    private var state:SignupState
    
    init(_ component: SignupComponent) {
        self.component = component
        _state = StateValue(component.state)
    }
    
    var body: some View{
        let name = Binding(get: { state.name }, set: component.onNameTextChanged)
        let surname = Binding(get: { state.surname }, set: component.onSurnameTextChanged)
        let email = Binding(get: { state.email }, set: component.onEmailTextChanged)
        let password = Binding(get: { state.password }, set: component.onPasswordTextChanged)
        
        VStack{
            TextField("Name",text: name)
            TextField("Surname",text: surname)
            TextField("Email",text: email)
            TextField("Password",text: password)
            Button(action: component.onCreateAccountClicked){
                Text("Create account")
            }.disabled(!state.isCreateAccountButtonEnabled)
        }.padding()
    }
}
