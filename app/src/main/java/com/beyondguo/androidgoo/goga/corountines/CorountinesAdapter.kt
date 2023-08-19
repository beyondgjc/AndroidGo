package com.beyondguo.androidgoo.goga.corountines

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beyondguo.androidgoo.R

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 12:54
 * @description
 */
class CorountinesAdapter(val context: Context,
    val corountinesList: List<CorountinesModel>) : RecyclerView.Adapter<CoroutinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoroutinesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.listitem_corountines,parent, false)
        return CoroutinesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return corountinesList.size
    }

    override fun onBindViewHolder(holder: CoroutinesViewHolder, position: Int) {
        holder.setContent(context, corountinesList[position])
    }
}