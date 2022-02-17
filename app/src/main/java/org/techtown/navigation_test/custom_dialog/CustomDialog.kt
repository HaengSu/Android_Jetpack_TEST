package org.techtown.navigation_test.custom_dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import org.techtown.navigation_test.R
//import android.app.DialogFragment;
import org.techtown.navigation_test.databinding.DialogBinding

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
        fun addContents(contents : String)
    }

    fun setContentsListener(sendContentsListener: sendContentsListener){
        mCallback = sendContentsListener
    }

}
























