//
//  MainView.swift
//  iosApp
//
//  Created by Alisher on 20/12/23.
//

import SwiftUI
import shared

struct MainView : View{
    private let component:MainComponent
    init(_ component: MainComponent) {
        self.component = component
    }
    
    var body: some View{
        Text("Main")
    }
}
