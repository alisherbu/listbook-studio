//
//  SignupView.swift
//  iosApp
//
//  Created by Alisher on 23/12/23.
//

import SwiftUI
import shared

struct SignupView : View{
    private let signupComponent:SignupComponent
    init(_ mainComponent: SignupComponent) {
        self.signupComponent = mainComponent
    }
    
    var body: some View{
        Text("Sign up")
    }
}
