package net.alhazmy13.demoproject.util

import android.app.Activity
import net.alhazmy13.demoproject.DemoApplication

val Activity.app: DemoApplication
    get() = application as DemoApplication
