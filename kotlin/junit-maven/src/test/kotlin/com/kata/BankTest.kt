package com.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class BankTest {
    lateinit var account: Account
    lateinit var bank: Bank

    @BeforeEach
    fun init() {
        account = Account(1000)
        bank = Bank(account)
    }

    @Test
    fun accessMyAccount() {
        // Act
        val bank = Bank(account)

        // Assert
        assertThat(bank.getAccount()).isNotNull;
    }

    @Test
    fun withdrawMoney() {
        // Arrange
        val moneyToBeWithdrawn = 500

        // Act
        bank.withdraw(moneyToBeWithdrawn)
        // Assert
        val expectedAmountLeft = 500
        assertThat(bank.getAccount().getBalance()).isEqualTo(expectedAmountLeft);
    }

    @Test
    fun depositMoneyOnAccount() {
        // Arrange
        val moneyAdded = 500

        // Act
        bank.deposit(moneyAdded)
        // Assert
        val expectedAmountLeft = 1500
        assertThat(bank.getAccount().getBalance()).isEqualTo(expectedAmountLeft);
    }

    @Test
    fun getMyLatestTransactions() {
        // Arrange
        bank.deposit(500)
        // Act
        val transactions = bank.getTransactions()

        // Assert
        val expectedTransactions = listOf(Transaction("deposit", "+500", 1500))
        assertThat(transactions).usingRecursiveComparison().isEqualTo(expectedTransactions)
    }
}
