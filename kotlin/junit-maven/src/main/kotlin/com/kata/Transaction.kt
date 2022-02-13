package com.kata

import java.time.LocalDate

class Transaction(private var type: String, private var amount: String, private var balance: Int, transactionDate: LocalDate = LocalDate.now()) {
}
