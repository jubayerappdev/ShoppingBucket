package com.creativeitinstitute.shoppingbucket.views.starter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.shoppingbucket.R
import com.creativeitinstitute.shoppingbucket.databinding.FragmentStartBinding


class StartFragment : Fragment() {

	//    lateinit var binding: FragmentStartBinding
	private var _binding: FragmentStartBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		_binding = FragmentStartBinding.inflate(inflater, container, false)

		setListener()
		return binding.root
	}

	private fun setListener() =
		with(binding) {
			btnLogin.setOnClickListener {
				findNavController().navigate(R.id.action_startFragment_to_loginFragment)
			}
			btnRegister.setOnClickListener {
				findNavController().navigate(R.id.action_startFragment_to_registerFragment)
			}
		}


	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}


}