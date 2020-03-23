package hu.ait.todorecyclerviewdemo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.GridLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import hu.ait.todorecyclerviewdemo.adapter.TodoAdapater
import hu.ait.todorecyclerviewdemo.data.Todo
import kotlinx.android.synthetic.main.activity_scrolling.*
import java.sql.Date

class ScrollingActivity : AppCompatActivity() {

    // Step 15: Create adapter var
    lateinit var todoAdapter: TodoAdapater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling) // Step 3: Go to the activity_scrolling XML (in res/layout)

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            // Oh no i don't know when we did this so i don't
            // have a step
            showAddTodoDialog()
        }

        // Step 16: Initialize the adapter
        // Now we're making things prettier, go to the todo row xml
        todoAdapter = TodoAdapater(this)
        recyclerTodo.adapter = todoAdapter

        // Step 21:
        val itemDecoration = DividerItemDecoration(
            this, DividerItemDecoration.VERTICAL
        )
        recyclerTodo.addItemDecoration(itemDecoration)

        // Step 21: Now lets make it a grid bc why not
        recyclerTodo.layoutManager = GridLayoutManager(this, 2)

    }

    // Step 19, then go to todorow.xml
    fun showAddTodoDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Create new todo")

        val etTodoText = EditText(this)
        builder.setView(etTodoText)

        builder.setPositiveButton("Ok") { dialog, which ->
            todoAdapter.addTodo(
                Todo(
                    Date(System.currentTimeMillis()).toString(),
                    false,
                    etTodoText.text.toString()
                )
            )
        }

        builder.show()
    }



    // Step 1: Delete onCreateOptionsMenu(...) and onOptionsItemSelected(...) bc won't use the toolbar
}
