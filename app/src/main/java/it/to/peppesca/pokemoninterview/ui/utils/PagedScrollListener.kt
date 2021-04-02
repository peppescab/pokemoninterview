package it.to.peppesca.pokemoninterview.ui.utils

import androidx.recyclerview.widget.RecyclerView

/**
 * A [RecyclerView.OnScrollListener] that signals in a [callback] that the
 * view has reached the last element.
 *
 * @param callback as the function to invoke when the scroll reach the bottom.
 */
class PagedScrollListener(
    private val callback: () -> Unit,
) : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (!recyclerView.canScrollVertically(1)) {
            callback()
        }
    }
}
