class Person(val name: String, var age: Int) {

    constructor(name: String) : this(name, 25){

        //Additional initialization logic speicific to this constructor
        println("Secondary Constructor #1: Person object with $name")
    }
    fun introduce(){
        println("Hi, my name is $name and I am $age years old.")
    }
}

fun main(){
    val nawaz = Person("Nawaz", 37)
    nawaz.introduce()

    val deepak = Person("Deepak",30)
    deepak.introduce()
}