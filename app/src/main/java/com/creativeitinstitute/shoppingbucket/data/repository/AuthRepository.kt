package com.creativeitinstitute.shoppingbucket.data.repository

import com.creativeitinstitute.shoppingbucket.data.models.UserRegistration
import com.creativeitinstitute.shoppingbucket.data.service.AuthService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthRepository : AuthService {

    override fun userRegistration(user: UserRegistration) : Task<AuthResult> {
        val jAuth = FirebaseAuth.getInstance()

      return jAuth.createUserWithEmailAndPassword(user.email,user.password)

    }

    override fun userLogin() {

    }
}