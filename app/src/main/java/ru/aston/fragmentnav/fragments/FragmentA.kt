package ru.aston.fragmentnav.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.aston.fragmentnav.MainActivity
import ru.aston.fragmentnav.R
import ru.aston.fragmentnav.UserListFragment

class FragmentA : Fragment() {

    private lateinit var buttontoB: Button
    private lateinit var buttonTask2: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttontoB = view.findViewById(R.id.fragA_buttontoB)
        buttonTask2 = view.findViewById(R.id.fragA_to_task2)

        buttontoB.setOnClickListener {
            (activity as MainActivity).openFragment(FragmentB(), true)
        }
        buttonTask2.setOnClickListener {
            (activity as MainActivity).openFragment(UserListFragment(), true)
        }
    }
}