package com.RageRacoon.learm_x_coffee.domain.use_cases.login

import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.domain.repository.AuthRepository
import javax.inject.Inject

class Register @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.register(user)
}