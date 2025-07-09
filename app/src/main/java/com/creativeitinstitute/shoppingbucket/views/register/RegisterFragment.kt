package com.creativeitinstitute.shoppingbucket.views.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.shoppingbucket.R
import com.creativeitinstitute.shoppingbucket.data.models.UserRegistration
import com.creativeitinstitute.shoppingbucket.databinding.FragmentRegisterBinding
import com.creativeitinstitute.shoppingbucket.isEmpty

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    private val viewModel: RegistrationViewModel by viewModels ()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container,false)

        setListener()

        return binding.root
    }

    private fun setListener() {

        with(binding){

            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
            btnRegister.setOnClickListener {
                etName.isEmpty()
                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etName.isEmpty() &&!etEmail.isEmpty() && !etPassword.isEmpty()){

                    Toast.makeText(context, "All input done!!!", Toast.LENGTH_LONG).show()

                    val user = UserRegistration(
                        etName.text.toString(),
                        etEmail.text.toString(),
                        etPassword.text.toString(),
                        "Seller",
                        ""
                    )

                    viewModel.userRegistration(user)
                }

            }
        }
    }


}