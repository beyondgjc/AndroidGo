package com.beyondguo.androidgoo.goga.menus

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/7 20:00
 * @description
 */
class CustomView(context: Context) : View(context) {
    private val paint = Paint()
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(300F, 300F, 200F, paint)
    }
}