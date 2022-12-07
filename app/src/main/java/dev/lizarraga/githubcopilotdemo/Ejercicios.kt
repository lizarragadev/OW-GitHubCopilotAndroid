package dev.lizarraga.githubcopilotdemo

// crear una funcion main
fun main() {
    val name = "Lizarraga"
    println("Hello $name!")
    printFirst20PrimeNumbers()
}

// create a function to print the first 20 prime numbers
fun printFirst20PrimeNumbers() {
    var count = 0
    var number = 2
    while (count < 20) {
        if (isPrime(number)) {
            println(number)
            count++
        }
        number++
    }
}

fun verifyAge(age: Int) {
    if (age >= 18) {
        println("You are an adult")
    } else {
        println("You are a minor")
    }
}

fun isEven(number: Int): Boolean {
    return number % 2 == 0
}

fun isOdd(number: Int): Boolean {
    return number % 2 != 0
}

fun isPrime(number: Int): Boolean {
    if (number <= 1) return false
    if (number == 2) return true
    var i = 2
    while (i <= Math.sqrt(number.toDouble())) {
        if (number % i == 0) {
            return false
        }
        i++
    }
    return true
}

fun isPalindrome(text: String): Boolean {
    val reverseText = text.reversed()
    return text == reverseText
}

fun isAnagram(text1: String, text2: String): Boolean {
    val array1 = text1.toCharArray()
    val array2 = text2.toCharArray()
    array1.sort()
    array2.sort()
    return array1.contentEquals(array2)
}

fun sumOfDigits(number: Int): Int {
    var sum = 0
    var num = number
    while (num != 0) {
        sum += num % 10
        num /= 10
    }
    return sum
}

fun sumOfDigitsRecursive(number: Int): Int {
    if (number == 0) return 0
    return number % 10 + sumOfDigitsRecursive(number / 10)
}

fun factorial(number: Int): Int {
    if (number <= 1) return 1
    return number * factorial(number - 1)
}

fun fibonacci(number: Int): Int {
    if (number <= 1) return number
    return fibonacci(number - 1) + fibonacci(number - 2)
}

fun fibonacciSequence(number: Int): String {
    var sequence = ""
    for (i in 1..number) {
        sequence += fibonacci(i).toString() + " "
    }
    return sequence
}

fun fibonacciSequenceRecursive(number: Int): String {
    if (number <= 1) return "1"
    return fibonacciSequenceRecursive(number - 1) + " " + fibonacci(number).toString()
}

fun reverseNumber(number: Int): Int {
    var num = number
    var reverse = 0
    while (num != 0) {
        reverse = reverse * 10 + num % 10
        num /= 10
    }
    return reverse
}

fun reverseNumberRecursive(number: Int): Int {
    if (number == 0) return 0
    return number % 10 + reverseNumberRecursive(number / 10) * 10
}