package com.beyondguo.androidgoo.goga

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.beyondguo.androidgoo.R
import com.beyondguo.androidgoo.goga.model.GogaMenuModel

class GogaMainViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val button: Button = view.findViewById(R.id.button)

    fun setContent(context: Context, gogaMenuModel: GogaMenuModel) {
        button.text = gogaMenuModel.name
        button.setOnClickListener {
            context.startActivity(Intent(context, gogaMenuModel.className))
        }
    }

}