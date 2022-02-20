package org.techtown.navigation_test.view_model.adpater

import android.animation.ValueAnimator
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.navigation_test.model.roomdb.NoteList
import org.techtown.navigation_test.databinding.RecyclerviewItemBinding

class NoteAdapter(val context: Context, var mList: ArrayList<NoteList>) :
    RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {
    private val TAG: String = "NoteAdapter"

    private lateinit var binding: RecyclerviewItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.MyViewHolder {
        binding =
            RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteAdapter.MyViewHolder, position: Int) {
        val item = mList[position]
        Log.d(TAG, "onBindViewHolder: item = ${item}")

        holder.bind()
        holder.binding.tvContents.text = item.contents
    }

    override fun getItemCount(): Int = mList.size

    inner class MyViewHolder(val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private var isHeart : Boolean = false

        fun bind() {

            binding.animationLottie.setOnClickListener {
                if (!isHeart) {
                    val animator = ValueAnimator.ofFloat(0f, 0.8f).setDuration(1000)
                    animator.addUpdateListener {
                        binding.animationLottie.progress = it.animatedValue as Float
                    }
                    animator.start()
                    isHeart = true
                    Log.d(TAG, "bind: 좋아요가 눌렸습니다. isHeart = ${isHeart}")
                }else {
                    val animator = ValueAnimator.ofFloat(0.8f, 1f).setDuration(1000)
                    animator.addUpdateListener {
                        binding.animationLottie.progress = it.animatedValue as Float
                    }
                    animator.start()
                    isHeart = false
                    Log.d(TAG, "bind: 좋아요가 눌렸습니다. isHeart = ${isHeart}")
                }
            }
        }
    }
}























