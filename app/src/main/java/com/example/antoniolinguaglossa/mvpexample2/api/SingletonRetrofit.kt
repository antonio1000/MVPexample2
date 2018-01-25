package com.example.antoniolinguaglossa.mvpexample2.api

class SingletonRetrofit private constructor() {

    init { println("This ($this) is a singleton") }

    private object Holder { val INSTANCE = SingletonRetrofit() }

    companion object {
        val instance: SingletonRetrofit by lazy { Holder.INSTANCE }
    }

    var mySingletonRetrofit = BackendServiceRetrofit.obtain().create(JournalerBackendService::class.java)!!

}