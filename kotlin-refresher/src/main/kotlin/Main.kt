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



}

fun fact(n: Int): Int {
    if(n == 0 || n == 1) {
        return 1
    }else{
        return n * fact(n - 1)
    }
}