package com.moonsmileh.nikesbcompendium.domain.usecase

import com.moonsmileh.nikesbcompendium.domain.NikeSBRepository
import javax.inject.Inject

class GetDunkByIdUseCase @Inject constructor(private val nikeSBRepository: NikeSBRepository) {

    suspend operator fun invoke(id: String) =
        nikeSBRepository.getDunkById(id)

}