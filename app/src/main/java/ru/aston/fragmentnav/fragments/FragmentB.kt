package ru.aston.fragmentnav.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.aston.fragmentnav.MainActivity
import ru.aston.fragmentnav.R

class FragmentB : Fragment() {

    private lateinit var buttontoC: Button
    private lateinit var buttontoA: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttontoA = view.findViewById(R.id.fragB_button_to_A)
        buttontoC = view.findViewById(R.id.fragB_button_to_C)

        buttontoC.setOnClickListener {
            val fragmentC = FragmentC()
            fragmentC.arguments = Bundle().apply {
                putString("message", context?.getString(R.string.hi_to_fragC))
            }
            (activity as MainActivity).openFragment(fragmentC, true)
        }

        buttontoA.setOnClickListener {
            (activity as MainActivity).clearBackStackAndOpenFragment(FragmentA())
        }
    }
}