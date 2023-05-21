package com.RageRacoon.learm_x_coffee.domain.use_cases.users
import com.RageRacoon.learm_x_coffee.domain.repository.UsersRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val repository: UsersRepository){
    operator fun invoke (id:String) = repository.getUser(id)
}