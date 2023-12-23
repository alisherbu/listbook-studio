//
//  ProfileView.swift
//  iosApp
//
//  Created by Alisher on 24/12/23.
//

import SwiftUI
import shared

struct ProfileView:View{
    private let component:ProfileComponent
    init(_ component: ProfileComponent) {
        self.component = component
    }
    var body: some View{
        Text("Profile")
    }
}
