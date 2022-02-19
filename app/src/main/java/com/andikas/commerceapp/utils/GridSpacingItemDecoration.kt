package com.andikas.commerceapp.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class GridSpacingItemDecoration(
    private val spanCount: Int,
    private val horizontalSpacing: Int,
    private val verticalSpacing: Int
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount

        outRect.left =
            column * horizontalSpacing / spanCount
        outRect.right =
            horizontalSpacing - (column + 1) * horizontalSpacing / spanCount
        if (position >= spanCount) {
            outRect.top = verticalSpacing
        }
    }
}