package com.example.kotlin02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.PI
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main()
    }

    private fun main() {

        var dice = Dice()

        println(dice.roll())

        var squareCabin = SquareCabin(6, 50.0)
        var roundHut = RoundHut(3, 10.0)
        var tower = Tower(4, 10.0, 2)

        println("SquareCabin: c=${squareCabin.capacity}, m=${squareCabin.buildingMaterial}, hasRoom=${squareCabin.hasRoom()}, floorArea=${squareCabin.floorArea()}")
        println("RoundHut: c=${roundHut.capacity}, m=${roundHut.buildingMaterial}, hasRoom=${roundHut.hasRoom()}, floorArea=${roundHut.floorArea()}, carpetSize=${roundHut.carpetSize()}")
        println("Tower: c=${tower.capacity}, m=${tower.buildingMaterial}, hasRoom=${tower.hasRoom()}, floorArea=${tower.floorArea()}, carpetSize=${tower.carpetSize()}")

        // Or simpler syntax
        with (squareCabin) {
            println("SquareCabin/with: c=${capacity}, m=${buildingMaterial}, hasRoom=${hasRoom()}, floorArea=${floorArea()}")
        }
        with (roundHut) {
            println("RoundHut/with: c=${capacity}, m=${buildingMaterial}, hasRoom=${hasRoom()}, floorArea=${floorArea()}, carpetSize=${carpetSize()}")
        }
        with (tower) {
            println("Tower/with: c=${capacity}, m=${buildingMaterial}, hasRoom=${hasRoom()}, floorArea=${floorArea()}, carpetSize=${carpetSize()}")
        }
    }

    class Dice {
        var sides = 6

        fun roll(): Int {
            val range = 1..sides
            val rand = range.random()

            println("Roll ${rand}")

            return rand
        }

        fun my(test: Int?) {
            if (test != null) {

            } else if (test != null && test > 0) {

            } else {

            }

            when (test != null && test < 0) {

            }
        }
    }

    abstract class Dwelling(private var residents: Int) {
        abstract val buildingMaterial: String
        abstract val capacity: Int
        abstract fun floorArea(): Double

        fun hasRoom(): Boolean {
            return residents < capacity
        }
    }

    class SquareCabin(residents: Int, val lenght: Double) : Dwelling(residents) {
        override val buildingMaterial: String
            get() = "Wood"
        override val capacity = 6

        override fun floorArea(): Double {
            return lenght * lenght
        }
    }

    open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
        override val buildingMaterial = "Straw"
        override val capacity = 4

        override fun floorArea(): Double {
            return PI * radius * radius
        }

        fun carpetSize(): Double {
            val diameter = 2 * radius

            return sqrt(diameter * diameter / 2)
        }
    }

    class Tower(residents: Int, radius: Double, private val floors: Int) : RoundHut(residents, radius) {
        override val buildingMaterial = "Stone"
        override val capacity = 4 * floors

        override fun floorArea(): Double {
            return super.floorArea() * floors
        }
    }
}




