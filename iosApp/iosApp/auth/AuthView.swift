//
//  AuthView.swift
//  iosApp
//
//  Created by Alisher on 20/12/23.
//

import SwiftUI
import shared

struct AuthView :View{
    private let authComponent:AuthComponent
    init(_ authComponent: AuthComponent) {
        self.authComponent = authComponent
    }
    
    var body: some View{
        VStack(){
            Button(action: {
                authComponent.onSignupClicked()
            }){
                Text("Create account")
            }
            Button(action: {
                authComponent.onSignInClicked()
            }){
                Text("Sign in")
            }
        }
    }
}
