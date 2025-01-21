open class Vehicle(val brand: String, val year: Int) {

    fun start(){
        println("Starting $brand() vehicle")
    }

    fun stop(){
        println("Stopping $brand() vehicle")
    }
}

//lets create subclass for this
class Car(brand: String, year: Int, val model: String)  : Vehicle(brand, year){
    fun drive(){
        println("$brand $model is driving")
    }
}

fun main(){
    val car = Car("Toyota", 2022, "Corolla")
    car.start()
    car.stop()
    car.drive()
}