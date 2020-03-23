package hu.ait.todorecyclerviewdemo.data

// Step 5: The to do data structure
// Step 1 of creating a list done (data), now on to XML
// Step 6: Create new todo_row.xml in res/layout and go to that

data class Todo(
    var createDate: String,
    var done: Boolean,
    var todoText: String)