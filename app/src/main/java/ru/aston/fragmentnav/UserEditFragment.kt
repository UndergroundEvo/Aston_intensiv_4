package ru.aston.fragmentnav

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class UserEditFragment : Fragment() {

    private var user: User? = null
    private lateinit var button_save : Button
    private lateinit var firstname_textedit : EditText
    private lateinit var secondname_textedit : EditText
    private lateinit var phone_textedit : EditText
    private lateinit var image_textedit : EditText

    companion object {
        fun newInstance(user: User): UserEditFragment {
            val fragment = UserEditFragment()
            fragment.arguments = Bundle().apply {
                putParcelable("user", user)
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_save = view.findViewById(R.id.button_Save)
        firstname_textedit = view.findViewById(R.id.editFirstName)
        secondname_textedit = view.findViewById(R.id.editSecondName)
        phone_textedit = view.findViewById(R.id.editPhoneNumber)
        image_textedit = view.findViewById(R.id.editImage)

        @SuppressLint("NewApi")
        user = arguments?.getParcelable("user",User::class.java)

        user?.let {
            firstname_textedit.setText(it.firstName)
            secondname_textedit.setText(it.lastName)
            phone_textedit.setText(it.phoneNumber)
            image_textedit.setText(it.photoUrl)
        }

        button_save.setOnClickListener {
            user?.let {
                it.firstName = firstname_textedit.text.toString()
                it.lastName = secondname_textedit.text.toString()
                it.phoneNumber = phone_textedit.text.toString()
                it.photoUrl = image_textedit.text.toString()

                parentFragmentManager.setFragmentResult(
                    "userEditResult",
                    Bundle().apply { putParcelable("updatedUser", it) }
                )

                parentFragmentManager.popBackStack()
            }
        }
    }
}
