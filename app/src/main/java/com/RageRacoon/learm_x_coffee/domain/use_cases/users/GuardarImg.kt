package com.RageRacoon.learm_x_coffee.domain.use_cases.users

import com.RageRacoon.learm_x_coffee.domain.repository.UsersRepository
import java.io.File
import javax.inject.Inject

class GuardarImg @Inject constructor( private val repository: UsersRepository){
    suspend operator fun invoke(file: File) = repository.saveImg(file)
}