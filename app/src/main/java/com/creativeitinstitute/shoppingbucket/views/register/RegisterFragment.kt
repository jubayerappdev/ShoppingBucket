package com.creativeitinstitute.shoppingbucket.views.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.shoppingbucket.R
import com.creativeitinstitute.shoppingbucket.databinding.FragmentRegisterBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class RegisterFragment : Fragment() {
	private var _binding: FragmentRegisterBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentRegisterBinding.inflate(inflater, container, false)
		// Inflate the layout for this fragment
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setListeners()
	}

	private fun setListeners() = with(binding) {
		btnLogin.setOnClickListener {
			findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
		}
		btnRegister.setOnClickListener {
			showDetails()
//			findNavController().navigate(R.id.action_registerFragment_to_dashBoardFragment)
		}
	}

	private fun showDetails(){
		val name=binding.inputUserName.editText?.text.toString()
		val email=binding.inputUserEmail.editText?.text.toString()
		val password=binding.inputUserPassword.editText?.text.toString()
		val passConfirm=binding.inputUserPasswordConfirm.editText?.text.toString()

		val arr=arrayOf(name,email,password,passConfirm)

		MaterialAlertDialogBuilder(requireContext())
			.setTitle("Details")
			.setItems(arr){ dialog, position ->

			}
			.setNeutralButton("Dismiss",null)
			.show()

	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}