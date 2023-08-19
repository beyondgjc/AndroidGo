package com.beyondguo.androidgoo.goga.corountines

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.beyondguo.androidgoo.R

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 12:55
 * @description
 */
class CoroutinesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val button = view.findViewById<Button>(R.id.button)

    fun setContent(context: Context, coroutineItem: CorountinesModel) {
        button.text = coroutineItem.name
        button.setOnClickListener {
            context.startActivity(Intent(context, coroutineItem.corountineItem))
        }
    }
}