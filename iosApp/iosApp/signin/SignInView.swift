//
//  SignInView.swift
//  iosApp
//
//  Created by Alisher on 23/12/23.
//

import SwiftUI
import shared

struct SignInView : View{
    private let signInComponent:SignInComponent
    init(_ mainComponent: SignInComponent) {
        self.signInComponent = mainComponent
    }
    
    var body: some View{
        Text("Sign In")
    }
}
