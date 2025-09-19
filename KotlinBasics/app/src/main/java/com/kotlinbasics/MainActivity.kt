package com.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
//        week02Variables()
//        week02Functions()
        week03Classes()
//        week03Collections()
    }
}

private fun week03Collections() {
    Log.d("KotlinWeek03","== Kotlin Collections ==")

    val fruits = listOf("apple", "banana", "Orange")
    val mutableFruits = mutableListOf("kiwi", "watermelon")
//    fruits.add("kiwi")
    mutableFruits.add("banana");

    Log.d("KotlinWeek03","Fruits : $fruits")
    Log.d("KotlinWeek03","Mutable Fruits : $mutableFruits")


    val scores = mapOf("kim" to 97, "Park" to 100, "Lee" to 99)
    Log.d("KotlinWeek03", "Scores : $scores")

    scores.forEach{(name, score) -> Log.d("KotlinWeek03","$name scored $score")}

    for(fruit in fruits){
        Log.d("KotlinWeek03","Fruit : $fruit")
    }

    for(fruit in mutableFruits){
        Log.d("KotlinWeek03","Mutable Fruits : $fruit")

    }

}

fun week02Variables() {
    println("Week02 Variables")

    val courseName = "Mobile Programming"
    // courseName = "IoT Programming"

    var week = 1
    week = 2

    println("Course : $courseName")
    println("Week : $week")

    println("== Kotlin Variables ==")

    val name : String = "Android"
    var version : Double = 8.1
    println("Hello $name $version")

    val age : Int = 23
    val height : Double = 173.6
    val isStudent : Boolean = true

    println("Age : $age, Height : $height, Student : $isStudent")

}

fun week02Functions() {
    println("== Week02 Functions ==")
//
//    fun greet(name: String) = "Hello, $name!"
//
//    println(greet("Android Developer"))
    println("== kotlin Functions ==")

    fun greet(name: String): String {
        return "Hello, $name"
    }

    fun add(a: Int, b: Int) = a + b

    fun introduse(name: String, age: Int = 19){
        println("My name is $name and I'm $age years old")
    }

    println(greet("kotlin"))
    println(add(12,-34))
    introduse("park")
    introduse("kim", 29)
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

fun week03Classes() {
    Log.d("kotlinWeek03", "== Kotlin Classes ==")
    
    class Person(val name: String, var age: Int){
        fun introduce(){
            Log.d("kotlinWeek03", "안녕하세요, $name ($age 세)입니다.")
        }
        fun birthday(){
            age++
            Log.d("KotlinWeek03", "$name 의 생일! 이제 $age 세...")
        }
    }

    val person1 = Person("홍길동", 31)
    person1.introduce()
    person1.birthday()

    class Animal(var species: String){
        var weight: Double = 0.0
        constructor(species: String, weight: Double) : this(species){
            this.weight = weight
            Log.d("KotlinWeek03", "$species 의 무게 : 이제 $weight kg")
        }
        fun makeSound() {
            Log.d("KotlinWeek03", "$species 가 소리를 냅니다")
        }
    }
    val puppy = Animal("강아지", 6.5)
    puppy.makeSound()

    class Dog()
//    class Student {
//        var name: String = ""
//        var age: Int = 0
//
//        fun introduse() {
//            println("Hi, I'm $name and I'm $age years old.")
//        }
//    }
//    val student = Student()
//    student.name = "Song"
//    student.age = 23
//    student.introduse()
//
//    class Person(val name: String, val age: Int)
//
//    val person1 = Person("Lee", 24)
//    val person2 = Person("Lee", 24)
//
//    println("Person1: $person1")
//    println("Equal? : ${person1 == person2}")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}