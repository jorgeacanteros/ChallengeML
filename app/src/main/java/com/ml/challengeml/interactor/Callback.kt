package com.ml.challengeml.interactor

/**
 * Created by Jorge on 21,febrero,2021
 */
interface Callback {
    fun onResponseOk(vararg objs: Any?)
    fun onResponseError(vararg objs: Any?)
}