abstract class Animal(val name: String) {

    abstract fun speak()

    fun eat(){
        println("$name is eating")
    }
}

//concrete subclass
class Horse(name: String) : Animal(name) {
    override fun speak() {
        println("$name is neighing")
    }
}

class Cat(name: String) : Animal(name) {
    override fun speak() {
        println("$name says meow")
    }
}

fun main(){
    val horse = Horse("Raja")
    horse.speak()
    horse.eat()

    val cat = Cat("Kitty")
    cat.speak()
    cat.eat()
}