package ru.aston.fragmentnav

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import ru.aston.fragmentnav.fragments.FragmentA

/**
 * "1) Создать 4 фрагмента A->B->C->D. Каждый открывает следующий фрагмент
 * * На фрагменте А отображается кнопка перехода на фрагмент B
 * * На фрагменте B отображается кнопки перехода на фрагмент C,  * а так же кнопка Назад, которая возвращает нас на фрагмент А.
 * При переходе на фрагмент C, при нажатии кнопки, мы так же должны передать строку с фразой ""Hello Fragment C""
 * * На фрагменте C отображается текстовое поле, в котором будет отображаться строка приходящая из фрагмента B.
 * Так же отображается кнопки перехода на фрагмент D и на фрагмент А( при этом должна сбрасываться вся цепочка вызовов)
 * * На фрагменте D отображается кнопка перехода на фрагмент B(сброс всей цепочки до фрагмента B)
 *
 * Использовать стандартные механизмы навигации для фрагментов
 *
 2) Написать приложение, которое будет отображать список пользователей(4 элемента) с полями фото/имя/фамилия/номер телефона.
 * При нажатии на элемент списка должна открываться страница для редактирования информации о пользователе. Для реализации использовать фрагменты.
 * 1. Создать фрагмент ""Список пользователей"", который будет содержать список пользователей с данными
 * 2. Создать фрагмент ""Редактирование информации о Пользователе"",
 * который будет содержать всю доступную информацию о выбранном пользователе, с возможностью ее редактирования.
 * 3. Реализовать навигацию между фрагментами при помощи стандартных механизмов навигации для фрагментов.
 * 4. Обеспечить возможность редактирования информации о пользователе,
 * так же ее сохранения и ее(обновленная информация) отображения на экране ""Список пользователей"", с помощью FragmentResultApi"
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (savedInstanceState == null) {
            openFragment(FragmentA(), false)
        }
    }

    fun openFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        Log.d("openFragment","fragment: ${fragment.id}")
        transaction.commit()
    }

    fun clearBackStackAndOpenFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
        openFragment(fragment, false)
    }
}