package com.kata

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class AccountTest {

    private lateinit var account: Account;

    @BeforeEach
    fun init() {
        account = Account()
    }

    @Test
    fun getMyAccountBalance() {
        // Arrange
        account = Account(500)
        // Act
        val balance = account.getBalance()

        // Assert
        assertThat(balance).isEqualTo(500)
    }
}
