package it.to.peppesca.pokemoninterview.ui.base

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * [BaseFragment] to handle binding common stuff
 */
abstract class BaseFragment<T : ViewBinding> : Fragment() {

    private var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    /**
     * Set here the binding
     */
    fun setBinding(binding: T) {
        _binding = binding
    }
}
