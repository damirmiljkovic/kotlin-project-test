package net.alhazmy13.demoproject

import android.app.Activity

val Activity.app: DemoApplication
    get() = application as DemoApplication
