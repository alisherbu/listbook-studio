@file:OptIn(BetaInteropApi::class, ExperimentalForeignApi::class)

package kaa.alisherbu.listbookstudio.shared

import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.destroy
import com.arkivanov.essenty.lifecycle.pause
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.essenty.lifecycle.start
import com.arkivanov.essenty.lifecycle.stop
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCAction
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSNotificationName
import platform.Foundation.NSSelectorFromString
import platform.UIKit.UIApplicationDidBecomeActiveNotification
import platform.UIKit.UIApplicationDidEnterBackgroundNotification
import platform.UIKit.UIApplicationWillEnterForegroundNotification
import platform.UIKit.UIApplicationWillResignActiveNotification
import platform.UIKit.UIApplicationWillTerminateNotification

class ApplicationLifecycle private constructor(
    private val lifecycle: LifecycleRegistry,
) : Lifecycle by lifecycle {

    constructor() : this(lifecycle = LifecycleRegistry())

    init {
        addObserver(
            name = UIApplicationWillEnterForegroundNotification,
            selectorName = "willEnterForeground"
        )
        addObserver(
            name = UIApplicationDidBecomeActiveNotification,
            selectorName = "didBecomeActive"
        )
        addObserver(
            name = UIApplicationWillResignActiveNotification,
            selectorName = "willResignActive"
        )
        addObserver(
            name = UIApplicationDidEnterBackgroundNotification,
            selectorName = "didEnterBackground"
        )
        addObserver(name = UIApplicationWillTerminateNotification, selectorName = "willTerminate")
    }

    private fun addObserver(name: NSNotificationName, selectorName: String) {
        NSNotificationCenter.defaultCenter.addObserver(
            name = name,
            `object` = null,
            observer = this,
            selector = NSSelectorFromString(selectorName),
        )
    }

    @ObjCAction
    fun willEnterForeground() {
        lifecycle.start()
    }

    @ObjCAction
    fun didBecomeActive() {
        lifecycle.resume()
    }

    @ObjCAction
    fun willResignActive() {
        lifecycle.pause()
    }

    @ObjCAction
    fun didEnterBackground() {
        lifecycle.stop()
    }

    @ObjCAction
    fun willTerminate() {
        lifecycle.destroy()
    }
}
