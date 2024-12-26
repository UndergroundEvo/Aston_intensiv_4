package ru.aston.fragmentnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment
import kotlin.random.Random

const val IMAGE_PLACEHOLDER = "https://via.assets.so/game.jpg?w=320&h=240"

class UserListFragment : Fragment() {


    private val users = mutableListOf<User>().apply {
        repeat(4) {
            add(
                User(
                    it, "FirstName$it", "SecondName$it",
                    "+7-${Random.nextInt(100, 999)}-${Random.nextInt(100, 999)}-${
                        Random.nextInt(10, 99)
                    }-${Random.nextInt(10, 99)}", IMAGE_PLACEHOLDER
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView: ListView = view.findViewById(R.id.listView)
        val adapter = UserListAdapter(requireContext(), users)
        listView.adapter = adapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val selectedUser = users[position]
                val fragment = UserEditFragment.newInstance(selectedUser)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main, fragment)
                    .addToBackStack(null)
                    .commit()
            }
    }
}