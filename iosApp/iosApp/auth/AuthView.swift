//
//  AuthView.swift
//  iosApp
//
//  Created by Alisher on 20/12/23.
//

import SwiftUI
import shared

struct AuthView :View{
    private let component:AuthComponent
    init(_ component: AuthComponent) {
        self.component = component
    }
    
    var body: some View{
        VStack(){
            Button(action: {
                component.onSignupClicked()
            }){
                Text("Create account")
            }
            Button(action: {
                component.onSignInClicked()
            }){
                Text("Sign in")
            }
        }
    }
}
