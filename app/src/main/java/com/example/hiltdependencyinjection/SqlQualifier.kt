package com.example.hiltdependencyinjection

import javax.inject.Qualifier


// This custom annotation is used for avoiding the typos.
@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class SqlQualifier