package com.arief.kotlinandroid.presenter

import com.arief.kotlinandroid.model.Todo

/**All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Originally written by Author Name Arief Maffrudin A N, 06/04/17
 */
class TodoMvp {

    interface TodoView{
        fun setData(listTodos: List<Todo>)
        fun setEmpty()
        fun setResult(message: String)
        fun onLoad(isLoad: Boolean)

    }

    interface TodoPresenter{
        fun insertData(todo: Todo)
        fun deleteData(id: Int)
        fun updateData(todo: Todo)
        fun getAllData()
    }
}