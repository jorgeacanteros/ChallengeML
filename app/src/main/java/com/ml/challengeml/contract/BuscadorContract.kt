package com.ml.challengeml.contract

interface BuscadorContract {
    interface presenter{
        suspend fun buscar(product: String)
    }
    interface view{

    }
}