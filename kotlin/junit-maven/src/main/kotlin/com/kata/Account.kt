package com.kata

import java.time.LocalDate

class Account(private var balance: Int = 0, private var transactions: MutableList<Transaction> = mutableListOf()) {
    fun getBalance(): Int {
        return this.balance
    }

    fun getTransactions(): List<Transaction> {
        return this.transactions
    }

    fun deposit(depositOnBalance: Int): Int {
        this.balance += depositOnBalance
        addToTransaction("deposit", depositOnBalance,balance)
        return this.balance
    }

    fun withdraw(amountToBeWithdrawn: Int): Int {
        if (balance < amountToBeWithdrawn) throw NegativeBalanceException()
        this.balance -= amountToBeWithdrawn
        addToTransaction("withdraw", amountToBeWithdrawn, balance)
        return this.balance
    }

    private fun addToTransaction(type: String, amountToBeWithdrawn: Int, balance: Int) {
        val amount = if ("deposit".equals(type)) "+$amountToBeWithdrawn" else "-$amountToBeWithdrawn"
        transactions.add(Transaction(type, amount, balance))
    }
}
