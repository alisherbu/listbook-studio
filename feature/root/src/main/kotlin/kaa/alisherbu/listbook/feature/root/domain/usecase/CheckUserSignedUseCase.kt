package kaa.alisherbu.listbook.feature.root.domain.usecase

import kaa.alisherbu.listbook.feature.root.domain.repository.RootRepository
import javax.inject.Inject

class CheckUserSignedUseCase @Inject constructor(
    private val rootRepository: RootRepository,
) {
    operator fun invoke(): Boolean {
        return rootRepository.checkUserSigned()
    }
}
