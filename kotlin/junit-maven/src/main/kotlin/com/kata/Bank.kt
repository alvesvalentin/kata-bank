package com.kata

class Bank(private val account: Account = Account()) {
    fun getAccount(): Account {
        return account
    }

    fun withdraw(amount: Int) {
        account.withdraw(amount)
    }

    fun deposit(amount: Int) {
        account.deposit(amount)
    }

    fun getTransactions(): List<Transaction> {
        return account.getTransactions()
    }
}
