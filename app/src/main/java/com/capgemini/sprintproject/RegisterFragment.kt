package com.capgemini.sprintproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    lateinit var userIdEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var password1EditText: EditText
    lateinit var password2EditText: EditText
    lateinit var registerButton:Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userIdEditText=view.findViewById(R.id.userIdE)
        emailEditText=view.findViewById(R.id.emailE)
        password1EditText=view.findViewById(R.id.passE)
        password2EditText=view.findViewById(R.id.passcheckE)
        registerButton=view.findViewById(R.id.register1B)

       /* arguments?.let { val mailid= it.getString("email")
            emailEditText.setText(mailid)}
            */


     //  val pass=password1EditText.text.toString()
       //val passCheck=password2EditText.text.toString()
        val email=emailEditText.text.toString()
        val userId=userIdEditText.text.toString()

        registerButton.setOnClickListener{

            if((password1EditText.text.toString()==password2EditText.text.toString())&& email.isNotEmpty())
            {

                Toast.makeText(requireContext(),"Account Created",Toast.LENGTH_LONG).show()
                findNavController().popBackStack(R.id.loginFragment,false)
            }
            else if(userId.isEmpty()||email.isEmpty()||password1EditText.text.toString().isEmpty()||password2EditText.text.toString().isEmpty()){
                Snackbar.make(requireView(), "Enter all fields", Snackbar.LENGTH_LONG).show()
        }
            else
            {
                Snackbar.make(requireView(), "Password mismatch", Snackbar.LENGTH_LONG).show()

            }


        }


        }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}