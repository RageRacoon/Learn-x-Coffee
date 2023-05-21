package com.RageRacoon.learm_x_coffee.di

import com.RageRacoon.learm_x_coffee.data.repository.AuthRepositoryImplement
import com.RageRacoon.learm_x_coffee.data.repository.UsersRepositoryImplements
import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.domain.repository.AuthRepository
import com.RageRacoon.learm_x_coffee.domain.repository.UsersRepository
import com.RageRacoon.learm_x_coffee.domain.use_cases.login.*
import com.RageRacoon.learm_x_coffee.domain.use_cases.users.Create
import com.RageRacoon.learm_x_coffee.domain.use_cases.users.Edit
import com.RageRacoon.learm_x_coffee.domain.use_cases.users.GetUserById
import com.RageRacoon.learm_x_coffee.domain.use_cases.users.ProfilesUseCase
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginViewModel
import com.RageRacoon.learm_x_coffee.utiles.Constantes
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    /**
     * Firebase AuthRepository Proovedores de la inyeccion de dependencias
     */

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(implementation: AuthRepositoryImplement): AuthRepository = implementation

    @Provides
    fun provideLoginUseCases(repository: AuthRepository)= LoginUseCase(
        getUser = GetUser(repository),
        login = Login(repository),
        loginOut = LoginOut(repository),
        register = Register(repository)
    )

    /**
     * FirebaseFirebaseFirestore Proovedores de la inyeccion de dependencias
     */
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore
    @Provides
    fun provideUserId(database: FirebaseFirestore): CollectionReference = database.collection(Constantes.USERS_COLLECTION_NAME)
    @Provides
    fun provideUserRepository(implementation: UsersRepositoryImplements):UsersRepository = implementation
    @Provides
    fun provideProfileUseCase(repository: UsersRepository) = ProfilesUseCase(    //esto es igual a la cal
        create = Create(repository),
        getUserById = GetUserById(repository),
        edit = Edit(repository)
    )
}