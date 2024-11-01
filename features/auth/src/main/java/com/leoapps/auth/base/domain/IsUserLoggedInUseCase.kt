package com.leoapps.auth.base.domain

import javax.inject.Inject

class IsUserLoggedInUseCase @Inject constructor() {

    operator fun invoke(): Boolean {
        return true
    }
}