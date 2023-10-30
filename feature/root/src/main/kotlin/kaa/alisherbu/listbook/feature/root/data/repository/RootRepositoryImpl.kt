package kaa.alisherbu.listbook.feature.root.data.repository

import com.google.firebase.auth.FirebaseAuth
import kaa.alisherbu.listbook.feature.root.domain.repository.RootRepository
import javax.inject.Inject

internal class RootRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
) : RootRepository {
    override fun checkUserSigned(): Boolean {
        return firebaseAuth.currentUser != null
    }
}
