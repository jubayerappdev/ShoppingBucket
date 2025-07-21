package com.creativeitinstitute.shoppingbucket.views.starter

import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.shoppingbucket.R
import com.creativeitinstitute.shoppingbucket.base.BaseFragment
import com.creativeitinstitute.shoppingbucket.databinding.FragmentStartBinding


class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {


    override fun setListener() {
        with(binding){
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_registerFragment)
            }
        }
    }

    override fun allObserver() {


    }


}