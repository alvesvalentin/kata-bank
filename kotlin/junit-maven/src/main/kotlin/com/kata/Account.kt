package com.kata

class Account(private var balance: Int = 0) {
    fun getBalance(): Int {
        return this.balance
    }

    fun deposit(depositOnBalance: Int): Int {
        this.balance += depositOnBalance
        return this.balance
    }

    fun withdraw(amountToBeWithdrawn: Int): Int {
        if (balance < amountToBeWithdrawn) throw NegativeBalanceException()
        this.balance -= amountToBeWithdrawn
        return this.balance
    }


}
