//
//  HomeView.swift
//  iosApp
//
//  Created by Alisher on 24/12/23.
//

import SwiftUI
import shared

struct HomeView:View{
    private let component:HomeComponent
    init(_ component: HomeComponent) {
        self.component = component
    }
    var body: some View{
        Text("Home")
    }
}
