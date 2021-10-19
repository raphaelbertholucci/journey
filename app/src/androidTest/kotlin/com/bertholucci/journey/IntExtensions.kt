package com.bertholucci.journey

import android.view.View
import androidx.test.espresso.Espresso.onView
import com.bertholucci.journey.RecyclerViewMatcher.Companion.withRecyclerView
import kotlin.test.assertTrue

inline fun <reified T : View> Int.checkRecyclerViewItem(
    position: Int,
    idItem: Int,
    crossinline assert: (T) -> Boolean
) {
    onView(withRecyclerView(this).atPositionOnView(position, idItem))
        .check { view, _ ->
            if (view is T) {
                assertTrue {
                    assert.invoke(view)
                }
            }
        }
}