package com.example.encuestaapp.data

import com.example.encuestaapp.data.model.LoggedInUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {
    private val auth: FirebaseAuth by lazy { Firebase.auth }
    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            val authResult = auth.signInWithEmailAndPassword(username, password).await()
            val user = LoggedInUser(authResult.user?.uid.toString(), authResult.user?.displayName.toString())
            return Result.Success(user)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}