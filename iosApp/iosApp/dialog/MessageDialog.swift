//
//  MessageDialogView.swift
//  iosApp
//
//  Created by Alisher on 23/12/23.
//

import SwiftUI
import shared

func MessageDialog(_ component:MessageDialogComponent)->Alert{
    return Alert(
        title: Text(component.message),
        dismissButton: Alert.Button.default(Text("Ok"), action: component.onDismissClicked)
    )
}
