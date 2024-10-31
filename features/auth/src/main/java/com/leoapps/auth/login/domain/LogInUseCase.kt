package com.leoapps.auth.login.domain

import kotlinx.coroutines.delay
import javax.inject.Inject

class LogInUseCase @Inject constructor() {

    operator suspend fun invoke(
        email: String,
        password: String
    ) {
        // Simulate a network request + assume that the request is successful
        delay(1500)
    }
}