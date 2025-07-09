package com.creativeitinstitute.shoppingbucket.views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.shoppingbucket.R
import com.creativeitinstitute.shoppingbucket.databinding.FragmentLoginBinding
import com.creativeitinstitute.shoppingbucket.isEmpty

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)

        setListener()

        return binding.root
    }

    private fun setListener() {

        with(binding){
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
            btnLogin.setOnClickListener {
                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etEmail.isEmpty() && !etPassword.isEmpty()){

                    Toast.makeText(context, "All input done!!!", Toast.LENGTH_LONG).show()
                }

            }
        }
    }


}