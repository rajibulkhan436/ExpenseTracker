package com.rajibul.expensetracker.domain.usecase.write_datastore

import com.rajibul.expensetracker.domain.repository.DatastoreRepository
import javax.inject.Inject

class EditLimitDurationUseCase @Inject constructor(
    private val datastoreRepository: DatastoreRepository
) {
    suspend operator fun invoke(duration: Int) {
        return datastoreRepository.writeLimitDurationToDataStore(duration)
    }
}