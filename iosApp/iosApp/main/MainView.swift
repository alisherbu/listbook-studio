//
//  MainView.swift
//  iosApp
//
//  Created by Alisher on 20/12/23.
//

import SwiftUI
import shared

struct MainView : View{
    private let mainComponent:MainComponent
    init(_ mainComponent: MainComponent) {
        self.mainComponent = mainComponent
    }
    
    var body: some View{
        Text("Main")
    }
}
