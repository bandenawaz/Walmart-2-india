fun main(args: Array<String>) {
    println("Hello World!")
    var name : String = "John"
    println(name);

    val emptyString = String()
    val greeting = "Hello, $name"
    println(greeting)

    val number = 10;

    if(number % 2 == 0){
        println("$number is even ")
    }else{
        println("$number is odd.")
    }

    //Null checks
    val nullableName : String? = null
    println(nullableName?.length)

    val n = 5
    val result = fact(n)
    println("Factorial of $n is $result")


    val sum = performOperation(5,8) { a, b -> a + b }
    val product = performOperation(5, 8) { a, b -> a * b }
    println("Sum $sum")
    println("Product $product");

}

//higher order functions
fun performOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int {

    return  operation(x,y)

}

fun fact(n: Int): Int {
    if(n == 0 || n == 1) {
        return 1
    }else{
        return n * fact(n - 1)
    }
}