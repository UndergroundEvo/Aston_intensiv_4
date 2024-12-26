package ru.aston.fragmentnav

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import coil3.load
import coil3.request.crossfade
import coil3.request.error

class UserListAdapter(
    private val context: Context,
    private val users: List<User>
) : BaseAdapter() {

    override fun getCount(): Int = users.size

    override fun getItem(position: Int): User = users[position]

    override fun getItemId(position: Int): Long = users[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.item_user, parent, false
        )

        val user = getItem(position)

        val imageView = view.findViewById<ImageView>(R.id.userImage)
        val nameTextView = view.findViewById<TextView>(R.id.userName)
        val phoneTextView = view.findViewById<TextView>(R.id.userPhone)

        imageView.load(user.photoUrl) {
            error(R.drawable.ic_launcher_foreground)
        }
        nameTextView.text = "${user.firstName} ${user.lastName}"
        phoneTextView.text = user.phoneNumber

        return view
    }
}