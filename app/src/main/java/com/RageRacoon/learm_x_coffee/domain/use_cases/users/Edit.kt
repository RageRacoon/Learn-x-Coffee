package com.RageRacoon.learm_x_coffee.domain.use_cases.users

import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.domain.repository.UsersRepository
import javax.inject.Inject

class Edit @Inject constructor(private val repository: UsersRepository){
    suspend operator fun invoke (user: User) = repository.edit(user)
}