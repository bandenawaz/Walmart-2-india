//sealed class LoginState {
//
//    object LoggedOut : LoginState()
//    object LoggingIn : LoginState()
//
//    data class LoggedIn(val user: User) : LoginState()
//    data class Error(val message: String) : LoginState()
//}
//
//fun handleLoginState(state: LoginState){
//    when(state){
//        is LoginState.LoggedOut -> println("User has logged out")
//        is LoginState.LoggingIn -> println("User has logged in")
//        is LoginState.LoggedIn -> println("User has logged in as ${state.user.name}")
//        is LoginState.Error -> println("Login error: ${state.message}")
//    }
//
//}

sealed class Result{
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
}

fun processResult(result: Result){
    when(result){
        is Result.Success -> println("Success: ${result.data}")
        is Result.Error -> println("Error: ${result.message}")
    }
}

fun main(){
//    val user = User("James", "james@bond.com")
//    val  loginState: LoginState = LoginState.LoggedIn(user)
//
//    handleLoginState(loginState)
    val successResult = Result.Success("Data Loaded Successfully")
    val errorResult = Result.Error("Failed to load data")
    processResult(successResult)
    processResult(errorResult)
}