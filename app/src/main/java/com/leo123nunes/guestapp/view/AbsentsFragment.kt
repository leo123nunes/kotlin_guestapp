package com.leo123nunes.guestapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.leo123nunes.guestapp.R
import com.leo123nunes.guestapp.viewModel.AbsentsViewModel

class AbsentsFragment : Fragment() {

    private lateinit var absentsViewModel: AbsentsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        absentsViewModel =
                ViewModelProviders.of(this).get(AbsentsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_absents, container, false)
        val textView: TextView = root.findViewById(R.id.text_absents)
        absentsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}