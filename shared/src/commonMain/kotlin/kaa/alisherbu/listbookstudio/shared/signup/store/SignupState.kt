package kaa.alisherbu.listbookstudio.shared.signup.store

data class SignupState(
    val name: String = "",
    val surname: String = "",
    val email: String = "",
    val password: String = "",
    val isCreateAccountButtonEnabled: Boolean = false,
)
