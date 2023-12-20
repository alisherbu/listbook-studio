//
//  RootView.swift
//  iosApp
//
//  Created by Alisher on 20/12/23.
//

import SwiftUI
import shared

struct RootView : View {
    let rootComponent:RootComponent
    init(_ rootComponent: RootComponent) {
        self.rootComponent = rootComponent
    }
    var body: some View{
        Text(verbatim: "Hello KMP")
    }
}
