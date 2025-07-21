package com.creativeitinstitute.shoppingbucket.views.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.creativeitinstitute.shoppingbucket.core.DataState
import com.creativeitinstitute.shoppingbucket.data.models.UserRegistration
import com.creativeitinstitute.shoppingbucket.data.repository.AuthRepository

class RegistrationViewModel : ViewModel(){

   private val _registrationResponse = MutableLiveData<DataState<UserRegistration>>()

    val registrationResponse: LiveData<DataState<UserRegistration>> = _registrationResponse



    fun userRegistration(user: UserRegistration){

        _registrationResponse.postValue(DataState.Loading())

        val authService  = AuthRepository()

        authService.userRegistration(user).addOnSuccessListener {

            _registrationResponse.postValue(DataState.Success(user))


            Log.d("TAG", "userRegistration: Success")

        }.addOnFailureListener {error->
            _registrationResponse.postValue(DataState.Error("${error.message}"))

            Log.d("TAG", "userRegistration: ${error.message}")
        }

    }
}