package com.rajibul.expensetracker.domain.usecase.write_datastore

import com.rajibul.expensetracker.domain.repository.DatastoreRepository
import javax.inject.Inject

class EditCurrencyUseCase @Inject constructor(private val datastoreRepository: DatastoreRepository) {
    suspend operator fun invoke(currency: String) {
        datastoreRepository.writeCurrencyToDataStore(currency)
    }
}