package com.kata

class NegativeBalanceException : Throwable() {

    override val message: String?
        get() = "Negative balance is forbidden."
}
