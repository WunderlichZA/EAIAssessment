package dev.proedva.androidassessmenteai.feature_operators.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.proedva.androidassessmenteai.databinding.FragmentOperationsBinding
import dev.proedva.androidassessmenteai.feature_operators.viewmodel.OperationsViewModel

class OperationsFragment : Fragment() {

    private var _binding: FragmentOperationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val operationsViewModel =
            ViewModelProvider(this)[OperationsViewModel::class.java]

        _binding = FragmentOperationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        operationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}