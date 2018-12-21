# MVP, CRUD with Kotlin
![alt text](https://github.com/ariefannur/MVPKotlin/blob/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png)

This is a sample project Android CRUD with MVP Architecture and Kotlin

##### Model
```kotlin
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

```

##### View

```kotlin
 interface TodoView{
        fun setData(listTodos: List<Todo>)
        fun setEmpty()
        fun setResult(message: String)
        fun onLoad(isLoad: Boolean)

    }

```

##### Presenter
```kotlin
interface TodoPresenter{
        fun insertData(todo: Todo)
        fun deleteData(id: Int)
        fun updateData(todo: Todo)
        fun getAllData()
    }

```

##### DBHelper.kt
```kotlin
class DbHelper : SQLiteOpenHelper {
    constructor(context: Context) : super(context, "DB", null, 1)

    val TB_TODO : String = "tb_todo"
    val COL_ID : String = "id"
    val COL_TITLE : String = "title"
    val COL_DESC : String = "desc"
    val COL_DATE : String = "date"

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var sql: String = "CREATE TABLE $TB_TODO ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_TITLE VARCHAR(30), $COL_DESC TEXT, $COL_DATE VARCHAR(10))"
        db?.execSQL(sql)
    }

    fun insertData(todo: Todo): Boolean{
        val db: SQLiteDatabase = this.writableDatabase

        var cv = ContentValues()
        cv.put(COL_TITLE, todo.mTitle)
        cv.put(COL_DESC, todo.mDesc)
        cv.put(COL_DATE, todo.mDate)
        return db.insert(TB_TODO, null, cv) > 0

    }
```


