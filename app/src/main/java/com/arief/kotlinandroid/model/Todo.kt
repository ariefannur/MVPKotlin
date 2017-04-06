package com.arief.kotlinandroid.model

/**All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Originally written by Author Name Arief Maffrudin A N, 06/04/17
 */
class Todo (id: Int, title: String, desc: String, date: String){
    var mId :Int = 0
    var mTitle: String? = ""
    var mDesc: String? = ""
    var mDate: String? = ""

    init {
        mId = id
        mTitle = title
        mDate = date
        mDesc = desc

    }
}