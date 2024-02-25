package com.moonsmileh.nikesbcompendium.domain.usecase

import com.moonsmileh.nikesbcompendium.domain.NikeSBRepository
import javax.inject.Inject

class GetDunksUseCase @Inject constructor(private val nikeSBRepository: NikeSBRepository) {
    suspend operator fun invoke() = nikeSBRepository.getAllDunks()

}