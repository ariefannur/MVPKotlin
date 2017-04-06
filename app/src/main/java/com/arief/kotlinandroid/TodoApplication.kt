package com.arief.kotlinandroid

import android.app.Application
import android.content.Context
import com.arief.kotlinandroid.repository.DbHelper

/**All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Originally written by Author Name Arief Maffrudin A N, 06/04/17
 */
class TodoApplication : Application(){

    public var db: DbHelper = DbHelper(this)
    override fun onCreate() {
        super.onCreate()

    }





}