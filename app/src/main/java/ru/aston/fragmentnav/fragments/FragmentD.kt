package ru.aston.fragmentnav.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.aston.fragmentnav.MainActivity
import ru.aston.fragmentnav.R

class FragmentD : Fragment() {

    private lateinit var buttontoB: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttontoB = view.findViewById(R.id.fragD_button_to_B)
        buttontoB.setOnClickListener {
            (activity as MainActivity).clearBackStackAndOpenFragment(FragmentB())
        }
    }
}