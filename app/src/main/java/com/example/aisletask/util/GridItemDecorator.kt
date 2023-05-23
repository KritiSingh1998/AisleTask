package com.example.aisletask.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridItemDecorator(private val spacing: Int, private val spanCount: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position % spanCount == 0) {
            outRect.left = spacing
            outRect.right = spacing / 2
        } else {
            outRect.left = spacing / 2
            outRect.right = spacing
        }
        outRect.top = 0
        outRect.bottom = spanCount
    }
}