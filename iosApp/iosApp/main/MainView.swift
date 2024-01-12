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
    
    @StateValue
    private var screenStack: ChildStack<AnyObject, MainComponentChildScreen>
    
    private var activeChild: MainComponentChildScreen { screenStack.active.instance }
    
    init(_ component: MainComponent) {
        self.component = component
        _screenStack = StateValue(component.screenStack)
    }
    
    var body: some View{
        VStack {
            ChildView(child: activeChild)
                .frame(maxHeight: .infinity)
            
            HStack(alignment: .bottom, spacing: 16) {
                Button(action: component.onHomeClicked) {
                    Label("Home", systemImage: "123.rectangle")
                        .labelStyle(VerticalLabelStyle())
                        .opacity(activeChild is MainComponentChildScreenHome ? 1 : 0.5)
                }
                
                Button(action: component.onProfileClicked) {
                    Label("Profile", systemImage: "list.bullet")
                        .labelStyle(VerticalLabelStyle())
                        .opacity(activeChild is MainComponentChildScreenProfile ? 1 : 0.5)
                }
            }
        }
    }
}

private struct ChildView: View {
    let child: MainComponentChildScreen
    
    var body: some View {
        switch child {
        case let child as MainComponentChildScreenHome: HomeView(child.component)
        case let child as MainComponentChildScreenProfile: ProfileView(child.component)
        default: EmptyView()
        }
    }
}

private struct VerticalLabelStyle: LabelStyle {
    func makeBody(configuration: Configuration) -> some View {
        VStack(alignment: .center, spacing: 8) {
            configuration.icon
            configuration.title
        }
    }
}
