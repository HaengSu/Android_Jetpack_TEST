package org.techtown.navigation_test.view

import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.EditText
import org.techtown.navigation_test.R
import org.techtown.navigation_test.model.roomdb.NoteDataTable

//import android.app.DialogFragment;

class CustomDialog (context : Context) : View.OnClickListener{
    private lateinit var mCallback : sendContentsListener
    private lateinit var edittx: EditText
    private lateinit var addbt : Button
    private lateinit var cancelbt : Button
    private val dialog = Dialog(context)


    fun showDialog() {
        dialog.setContentView(R.layout.dialog)
        dialog.setCanceledOnTouchOutside(true)
//        dialog.setCancelable(true)
        dialog.show()

        edittx = dialog.findViewById<EditText>(R.id.editText)
        addbt = dialog.findViewById<Button>(R.id.add_button)
        cancelbt = dialog.findViewById<Button>(R.id.cancel_button)

        addbt.setOnClickListener(this)
        cancelbt.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {

            addbt.id -> {
                var str = edittx.text.toString()
                mCallback.addContents(str)
                dialog.dismiss()
            }
            cancelbt.id -> {
                dialog.dismiss()
            }
        }
    }


    interface sendContentsListener {
        fun addContents(str : String)
    }

    fun setContentsListener(sendContentsListener: sendContentsListener){
        mCallback = sendContentsListener
    }

}
























