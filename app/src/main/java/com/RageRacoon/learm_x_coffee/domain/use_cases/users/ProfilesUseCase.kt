package com.RageRacoon.learm_x_coffee.domain.use_cases.users

data class ProfilesUseCase(
    val create: Create,
    val getUserById: GetUserById,
    val edit: Edit,
    val guardarImg: GuardarImg
)
