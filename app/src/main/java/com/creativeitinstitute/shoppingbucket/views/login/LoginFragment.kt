package com.creativeitinstitute.shoppingbucket.views.login

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.shoppingbucket.R
import com.creativeitinstitute.shoppingbucket.base.BaseFragment
import com.creativeitinstitute.shoppingbucket.databinding.FragmentLoginBinding
import com.creativeitinstitute.shoppingbucket.isEmpty

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override fun setListener() {

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

    override fun allObserver() {

    }


}