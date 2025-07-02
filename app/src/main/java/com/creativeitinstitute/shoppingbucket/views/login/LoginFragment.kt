package com.creativeitinstitute.shoppingbucket.views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.shoppingbucket.R
import com.creativeitinstitute.shoppingbucket.databinding.FragmentLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginFragment : Fragment() {
	private var _binding: FragmentLoginBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentLoginBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setListeners()
	}

	private fun setListeners() = with(binding) {
		btnLogin.setOnClickListener {
			showDetails()
//			findNavController().navigate(R.id.action_loginFragment_to_dashBoardFragment)
		}
		btnSignup.setOnClickListener {
			findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
		}
	}

	private fun showDetails() {
		val name = binding.inputUserName.editText?.text.toString()
		val password = binding.inputUserPassword.editText?.text.toString()

		val arr = arrayOf(name, password)

		MaterialAlertDialogBuilder(requireContext()).setTitle("Details")
			.setItems(arr) { dialog, position ->

			}
			.setNeutralButton("Dismiss", null)
			.show()

	}


	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}


}