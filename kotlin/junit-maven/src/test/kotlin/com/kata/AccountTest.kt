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

    @Test
    fun deposit500IntoMyAccount() {
        // Act
        val deposit = account.deposit(500)

        // Assert
        assertThat(deposit).isEqualTo(500)
    }

    @Test
    fun deposit1000IntoMyAccountWithAStartBalanceOf500() {
        // Arrange
        account = Account(500)

        // Act
        val deposit = account.deposit(1000)

        // Assert
        assertThat(deposit).isEqualTo(1500)
    }

    @Test
    fun withdraw500FromMyAccount() {
        // Arrange
        account = Account(1000)

        // Act
        var withdraw = account.withdraw(500)

        // Assert
        assertThat(withdraw).isEqualTo(500)
    }

    @Test
    fun preventWithdrawMoreMoneyThanAvailableinMyAccount() {
        // Act & Assert
        assertThatThrownBy { account.withdraw(500) }
            .hasMessage("Negative balance is forbidden.")
    }
}
