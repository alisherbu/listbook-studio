import SwiftUI
import Firebase
import shared

@main
struct iOSApp: App {
    init(){
        FirebaseApp.configure()
    }
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate:AppDelegate
    
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
