package com.rajibul.expensetracker.domain.usecase.read_database

import com.rajibul.expensetracker.data.local.entity.TransactionDto
import com.rajibul.expensetracker.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeeklyExpTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    operator fun invoke(): Flow<List<TransactionDto>> {
        return transactionRepository.getWeeklyExpTransaction()
    }
}