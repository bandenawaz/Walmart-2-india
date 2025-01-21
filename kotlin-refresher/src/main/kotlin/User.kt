
//Example for visibility
class User(val name: String, private val email: String) {

    var membershipType: String = "Basic"

    fun upgradeMemberhip(type: String){
        if(type == "Premium" || type == "Basic"){
            membershipType = type
        }
    }

    fun displayInfo(){
        println("Name: $name, Email: $email, Membership: $membershipType")
    }
}

fun main(){
    val user = User("Nawaz", "nawaz@gmail.com")
    user.displayInfo()
    user.upgradeMemberhip("Premium")
    user.displayInfo()
}