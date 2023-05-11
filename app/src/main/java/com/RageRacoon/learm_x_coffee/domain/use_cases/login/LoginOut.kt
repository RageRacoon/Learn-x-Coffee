package com.RageRacoon.learm_x_coffee.domain.use_cases.login

import com.RageRacoon.learm_x_coffee.domain.repository.AuthRepository
import javax.inject.Inject

class LoginOut @Inject constructor(private val repository: AuthRepository){
    operator fun invoke() = repository.loginOut()
}