package com.nepdire.realm

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()

        //init Realm
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("Notes.db")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .build()

        Realm.setDefaultConfiguration(config)
    }

}