package com.kata

class Account(private var balance: Int = 0, private var transactions: MutableList<Transaction> = mutableListOf()) {
    fun getBalance(): Int {
        return this.balance
    }

    fun getTransactions(): List<Transaction> {
        return this.transactions
    }

    fun deposit(depositOnBalance: Int): Int {
        this.balance += depositOnBalance
        transactions.add(Transaction("deposit", "+$depositOnBalance",balance))
        return this.balance
    }

    fun withdraw(amountToBeWithdrawn: Int): Int {
        if (balance < amountToBeWithdrawn) throw NegativeBalanceException()
        this.balance -= amountToBeWithdrawn
        return this.balance
    }


}
