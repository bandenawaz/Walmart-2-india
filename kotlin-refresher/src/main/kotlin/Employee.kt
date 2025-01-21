data class Employee(val name: String, val age: Int, val salary: Double)

data class Address(val street: String, val city: String, val zipcode: String)
data class SomeUser(val name: String, val email: String, val address: Address)

fun main(){
    val employee = Employee("Nawaz", 37, 50000.00)
    println(employee)

    val employee2 = Employee("Saurabh", 28, 1200000.00)
    println(employee2)

    println(employee2.toString())

    val address = Address("123 Main St", "Anytown", "12345")
    val user = SomeUser("Nawaz", "nawaz@gmail", address)
    println(user)
}
