import SwiftUI
import shared

@main
struct iOSApp: App {
    init(){
        Firebase.initialize()
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
