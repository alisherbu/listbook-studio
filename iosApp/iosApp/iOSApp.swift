import SwiftUI
import Firebase
import shared

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate:AppDelegate
    init() {
        FirebaseApp.configure()
    }
    
    var body: some Scene {
        WindowGroup {
            RootView(appDelegate.rootComponent)
        }
    }
}

class AppDelegate: NSObject, UIApplicationDelegate {
    let rootComponent: RootComponent = RootComponentImpl(
        componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle())
    )
}
