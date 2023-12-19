package kaa.alisherbu.listbookstudio.shared.auth

interface AuthComponent {
    fun onSignupClicked()

    fun onSignInClicked()

    sealed class Output {
        data object Signup : Output()
        data object SignIn : Output()
    }
}