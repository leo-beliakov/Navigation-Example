package com.leoapps.auth.signup.domain

import kotlinx.coroutines.delay
import javax.inject.Inject

class SignUpUseCase @Inject constructor() {

    operator suspend fun invoke(
        email: String,
        name: String,
        password: String
    ) {
        // Simulate a network request + assume that the request is successful
        delay(1500)
    }
}