package com.creativeitinstitute.shoppingbucket.data.service

import com.creativeitinstitute.shoppingbucket.data.models.UserLogin
import com.creativeitinstitute.shoppingbucket.data.models.UserRegistration
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthService {

    fun userRegistration(user: UserRegistration): Task<AuthResult>
    fun userLogin(user: UserLogin): Task<AuthResult>
    fun createUser(user: UserRegistration): Task<Void>

}