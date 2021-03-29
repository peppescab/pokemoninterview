package it.to.peppesca.pokemoninterview.utils

/**
 * This is interface related to on item selected callback.
 */
fun interface OnItemSelected<T> {

    /**
     * Notifies that an item [T] have been selected.
     */
    fun onItemSelected(item: T)
}
