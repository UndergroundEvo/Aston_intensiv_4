package ru.aston.fragmentnav.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.aston.fragmentnav.MainActivity
import ru.aston.fragmentnav.R

class FragmentC : Fragment() {

    private lateinit var textMessage: TextView
    private lateinit var buttontoD: Button
    private lateinit var buttontoC: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textMessage = view.findViewById(R.id.textMessage)
        buttontoD = view.findViewById(R.id.fragC_button_to_D)
        buttontoC = view.findViewById(R.id.fragC_button_to_A)

        val message = arguments?.getString("message")
         textMessage.text = message

        buttontoD.setOnClickListener {
            (activity as MainActivity).openFragment(FragmentD(), true)
        }

        buttontoC.setOnClickListener {
            (activity as MainActivity).clearBackStackAndOpenFragment(FragmentA())
        }
    }
}