package com.creativeitinstitute.shoppingbucket.views.login

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.shoppingbucket.R
import com.creativeitinstitute.shoppingbucket.base.BaseFragment
import com.creativeitinstitute.shoppingbucket.core.DataState
import com.creativeitinstitute.shoppingbucket.data.models.UserLogin
import com.creativeitinstitute.shoppingbucket.databinding.FragmentLoginBinding
import com.creativeitinstitute.shoppingbucket.isEmpty
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels ()

    override fun setListener() {

        with(binding){
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
            btnLogin.setOnClickListener {
                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etEmail.isEmpty() && !etPassword.isEmpty()){

                    val user = UserLogin(etEmail.text.toString(), etPassword.text.toString())

                    viewModel.userLogin(user)

                    loading.show()

//                    Toast.makeText(context, "All input done!!!", Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    override fun allObserver() {
        viewModel.loginResponse.observe(viewLifecycleOwner){

            when(it){
                is DataState.Error -> {
                    loading.dismiss()
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading->
                {
                    loading.show()
                    Toast.makeText(context, "Loading.....", Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    loading.dismiss()
                    Toast.makeText(context, "User logged in: ${it.data}", Toast.LENGTH_SHORT).show()
                   findNavController().navigate(R.id.action_loginFragment_to_dashBoardFragment)
                }
            }
        }
    }
}