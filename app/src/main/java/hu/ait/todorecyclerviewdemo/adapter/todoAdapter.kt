package hu.ait.todorecyclerviewdemo.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hu.ait.todorecyclerviewdemo.R
import hu.ait.todorecyclerviewdemo.data.Todo
import kotlinx.android.synthetic.main.todo_row.view.*

// Step 9: Create the class, will be red until the three adapter functions are overridden
// onCreateViewHolder(...), getItemCount(), onBindViewHolder(...)
class TodoAdapater: RecyclerView.Adapter<TodoAdapater.ViewHolder>{

    // Step 12: create some a list with some items
    var todoItems = mutableListOf<Todo>(
        Todo("2020. 03. 12.", false, "Todo1"),
        Todo("2020. 03. 11.", false, "Todo2")
    )

    // Super class of the activity
    val context : Context

    // Step 13: create a constructor for the class (will get rid of a lot
    // of the red!
    constructor(context: Context) {
        this.context = context
    }

    // Step 14: Override the  methods onCreateViewHolder(...), getItemCount(), onBindViewHolder(...)

    // Step 14a: Here we inflate the layout and then must return a ViewHolder object
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.todo_row, parent, false)

        return ViewHolder(view)
    }

    // Step 14b: hella easy one, just return the size
    override fun getItemCount(): Int {
        return todoItems.size
    }

    // Step 14c: now all the red will go away! After you create, go to ScrollingActivity
    // stuff in each individual item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentTodo = todoItems[position]
        // update text and swtich to done is check box is checked
        holder.tvDate.text = currentTodo.createDate
        holder.cbDone.text = currentTodo.todoText
        holder.cbDone.isChecked = currentTodo.done

        // Step 24: delete buttons for every item
        holder.deleteBtn.setOnClickListener {
            deleteTodo(holder.adapterPosition)
        }
    }

    // Step 25: Add a new method for the inside of the delete button thing to keep the onbindview holder short
    private fun deleteTodo(position: Int) {
        todoItems.removeAt(position)
        notifyItemRemoved(position)
    }

    // Step 18:
    public fun addTodo(todo: Todo) {
        todoItems.add(todo)

        notifyItemInserted(todoItems.lastIndex)
        // now go to scrollingActivity
    }

    // Step 10: Create the ViewHolder class
    // Inner class allows you to use the variables from the outer class in an init{} (this is the default in java)
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //Step 23: Make edits to reflect the new delete button
        // then need to give an onclick listener for every item in the list
        val deleteBtn = itemView.deleteBtn
        // Step 11: set these vals to their value
        val tvDate = itemView.tvDate
        val cbDone = itemView.cbDone


    }

}