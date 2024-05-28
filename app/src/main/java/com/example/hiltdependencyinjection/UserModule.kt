package com.example.hiltdependencyinjection

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Named
import javax.inject.Singleton

// When we will use the Module: -
// Let suppose for DI, we need to provide the object of the 3rd party library object
// Since, we cannot make the changes in the constructor ( we cannot annotate the class
// with @Inject annotation )
// Many other use cases like for interface and abstract classes. Since, we cannot
// create the object of the interface and abstract classes.
// Module will have some functions which will define how to create the object those classes.

// In @InstallIn parameter we provide the component class. In Dagger2 we need to make
// define the component interface but in Hilt, by default It provide some ClassComponent
// SingletonComponent -> this used for providing dependencies at the application level
// which means it will be even available to activity and fragment/ screen level.
// ActivityComponent -> this used for providing the dependencies at the activity level.
// Similarly, there is FragmentComponent you refer to the documentation.

@InstallIn(ActivityComponent::class)
@Module
class UserModule {
    @Named("firebase")
    @Provides
    fun provideFirebaseRepository():UserRepository{
        return FirebaseRepository()
    }

//    @Binds
//    using @Provides and @Binds will create this error: A @Module may not contain both non-static and abstract binding methods
//    abstract fun provideSQLRepository(sqlRepository: SQLRepository):UserRepository

    @SqlQualifier
    @Provides
//    @FragmentScoped
//    @Singleton
//    There is no point of using @FragmentScoped and @Singleton annotation and it will give
//    error: [Dagger/IncompatiblyScopedBindings]
//    Since, we have used ActivityComponent we already made it Activity Scoped
    fun provideSQLRepository(): UserRepository{
        return SQLRepository()
    }
}