package example

fun exampleFunction(mandatoryArgument: String, optionalArgument: Boolean = false) {
    println("This is an example function !")
    println("The mandatory argument was $mandatoryArgument")
    if (optionalArgument) println("optionalArgument was true")
}

class Example(val intInConstructor: Int, nonAttribute: Boolean = false, val optionnalInt: Int = 5) {
    val attribute = if (nonAttribute) "nonAttribute" else "Attribute"
    val initializedInInit: Int

    init {
        initializedInInit = 5
    }

    lateinit var badExample: String
    fun exampleMethod(): Int {
        return intInConstructor * initializedInInit
    }

    fun otherWayToWriteIt() = intInConstructor * initializedInInit
}

data class DataClassExample(val test: Int)

fun main(args: Array<String>) {
    // Some example on functions
    exampleFunction("mandatoryArgument")
    exampleFunction("otherMandatoryArgument", true)

    // Some examples on classes
    val example = Example(5)
    val otherExample = Example(5, false, 4)

    val dataExample = DataClassExample(1)

    println(example)
    println(dataExample)

    // Some examples on lambda/functional paradigm
    val list = listOf(2, 3, 54, 6, 7, 69)
    println(list)
    // Beware ! This list is not mutable !
    // To make it mutable, you'd need to use "mutableListOf"
    val listOfSquared = list.map { it * it }
    println("Usage of .map: $listOfSquared")
    val maxOfAFunction = list.maxOf { 2 * it * it - 5 * it + 10 }
    println("Max of a function! $maxOfAFunction")
    // List construction by lambda
    val listByLambda = List(10) { it }
    println("List by lambda: $listByLambda")
}