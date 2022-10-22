package com.socialdragon.android.tukio.presentation.auth.let_us_in

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.socialdragon.android.tukio.R

class LetUsInFragment : Fragment() {

    companion object {
        fun newInstance() = LetUsInFragment()
    }

    private lateinit var viewModel: LetUsInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_let_us_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[LetUsInViewModel::class.java]

    }
}