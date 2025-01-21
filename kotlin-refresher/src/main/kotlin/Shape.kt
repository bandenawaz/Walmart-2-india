open class Shape {

    open fun draw() {
        println("Drawing a shape")
    }
}

class Circle : Shape(){

    override fun draw() {
        println("Drawing a circle")
    }
}

class Square : Shape(){

    override fun draw() {
        println("Drawing a square")
    }
}

fun main(){
    val shapes : Array<Shape> = arrayOf(Circle(), Square())
    for (shape in shapes){
        shape.draw()
    }
}