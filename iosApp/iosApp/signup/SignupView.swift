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
    init(_ component: SignupComponent) {
        self.component = component
    }
    
    var body: some View{
        Text("Sign up")
    }
}
