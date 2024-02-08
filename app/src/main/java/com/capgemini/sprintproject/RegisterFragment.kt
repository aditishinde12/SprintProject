package com.capgemini.sprintproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.capgemini.tasktracker.model.User
import com.capgemini.tasktracker.viewmodel.TaskViewModel
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var taskVM: TaskViewModel
    var isRegisterClicked=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        taskVM = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskVM.isUserAdded.observe(this) {
            if (isRegisterClicked) {
                if (!it) {
                    Toast.makeText(requireContext(), "Username already exists", Toast.LENGTH_SHORT)
                        .show()
                }


            }
        }

    }    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_register, container, false)
        }


        lateinit var emailEditText: EditText
        lateinit var password1EditText: EditText
        lateinit var password2EditText: EditText
        lateinit var registerButton: Button

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            emailEditText = view.findViewById(R.id.emailE)
            password1EditText = view.findViewById(R.id.passE)
            password2EditText = view.findViewById(R.id.passcheckE)
            registerButton = view.findViewById(R.id.register1B)


            registerButton.setOnClickListener {
                isRegisterClicked = true
                val email = emailEditText.text.toString()
                var pwd1 = password1EditText.text.toString()
                var pwd2 = password2EditText.text.toString()

                if (email.isEmpty() || pwd1.isEmpty() || pwd2.isEmpty())
                {
                    Snackbar.make(requireView(), "Enter all fields", Snackbar.LENGTH_LONG).show()
                }
                else if (pwd1!=pwd2) {
                    Snackbar.make(requireView(), "Password mismatch", Snackbar.LENGTH_LONG).show()
                }
                else
                {
                    val user = User(email = email, password = pwd1)
                    taskVM.insertUser(user)

                    Toast.makeText(requireContext(), "Account Created", Toast.LENGTH_LONG).show()
                    findNavController().popBackStack(R.id.loginFragment, false)
                }
            }
        }

    }
