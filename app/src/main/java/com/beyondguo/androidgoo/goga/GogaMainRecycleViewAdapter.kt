package com.beyondguo.androidgoo.goga

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beyondguo.androidgoo.R
import com.beyondguo.androidgoo.goga.model.GogaMenuModel

class GogaMainRecycleViewAdapter(private val context: Context,
                                 private val menuList: List<GogaMenuModel>,
                                 private val listitemLayout: Int = R.layout.listitem_goga ) :
        RecyclerView.Adapter<GogaMainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GogaMainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(listitemLayout, parent, false)
        return GogaMainViewHolder(view)
    }

    override fun getItemCount() = menuList.size

    override fun onBindViewHolder(holder: GogaMainViewHolder, position: Int) {
        holder.setContent(context, menuList[position])
    }
}