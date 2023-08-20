package com.beyondguo.androidgoo.goga.corountines.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.beyondguo.androidgoo.R
import com.beyondguo.androidgoo.data.local.entity.User
import com.bumptech.glide.Glide

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 18:54
 * @description
 */
class UserAdapter(
    private val users: ArrayList<User>
): RecyclerView.Adapter<UserAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.findViewById<AppCompatTextView>(R.id.textViewUserName).text = user.name
            itemView.findViewById<AppCompatTextView>(R.id.textViewUserEmail).text = user.email
            Glide.with(itemView.findViewById<ImageView>(R.id.imageViewAvatar).context)
                .load(user.avatar).into(itemView.findViewById(R.id.imageViewAvatar))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_coroutines_user, parent, false))
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addData(list: List<User>){
        users.addAll(list)
    }
}