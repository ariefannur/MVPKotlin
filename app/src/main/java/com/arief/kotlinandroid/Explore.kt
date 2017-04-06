package com.arief.kotlinandroid

import android.util.Log
import java.util.*

/**All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Originally written by Author Name Arief Maffrudin A N, 05/04/17
 */
class Explore (name: String){

    val exsample_a: String = "ini adalah string"
    val example_b : String = "ini adalah string"

    fun method_void(){

    }

    fun sum(a :Int, b: Int) : Int = a + b

    fun getUser() : String {
        return example_b
    }

    fun getday(day: Int) : String =
            when(day) {
                1 -> "Senin"
                2 -> "Selasa"
                3 -> "Rabu"
                4 -> "Kamis"
                else -> "weekend"
            }

    fun range(a: Int, b: Int) : Int{
        var sum: Int = 0
        for(i in a.. b){
            sum+= i
        }
        Log.d("AF", "range $sum")
        return sum
    }

    fun rangeUntil(a: Int, b: Int) : Int {
        var sum: Int = 0
        for (i in a.. b){
            if(i in 1..10){
                sum+=i
            }
        }
        Log.d("AF", "range until $sum")
        return sum
    }

    var lsString: MutableList<String> = ArrayList<String>()
    fun generateList(name: String){
        lsString.add(name)
        Log.d("AF", name)
    }

    fun generateAllList(){
        for (i in 1..10){
            generateList("Aku $i")
        }
    }

    fun executeWhen(){
        for (i in 1..10){
            val day: String = getday(i)
            Log.d("AF", day)
        }
    }


}