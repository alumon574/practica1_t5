package com.example.practica1_t5.ui.Trash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.practica1_t5.databinding.FragmentTrashBinding

class TrashFragment : Fragment() {

    private var _binding: FragmentTrashBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val trashViewModel =
            ViewModelProvider(this).get(TrashViewModel::class.java)

        _binding = FragmentTrashBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTrash
        trashViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}