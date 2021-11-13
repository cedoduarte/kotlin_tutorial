package com.example.tutorial01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

typealias MyMapList = MutableMap<Int,ArrayList<String>>
typealias  MyFun = (Int, String, MyMapList) -> Boolean
typealias  MyNestedClass = MyNestedAndInnerClass.MyNestedClass


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // leccion 1
        variablesyconstantes()

        // leccion 2
        tiposDeDatos()

        // leccion 3
        sentenciaIf()

        // leccion 4
        sentenciaWhen()

        // leccion 5
        arrays()

        // leccion 6
        maps()

        // leccion 7
        loops()

        // leccion 8
        nullSafety()

        // leccion 9
        funciones()

        // leccion 10
        classes()

        // enum classes
        enumClasses()

        // nested and inner classes
        nestedAndInnerClasses()

        herencia()

        interfaces()

        modificadorDeVisibilidad()

        dataClasses()

        typeAliases()

        extensions()

        lambdas()
    }

    private fun lambdas() {
        val myIntList = arrayListOf(0,1,2,3,4,5,6,7,8,9)
        val myFilterIntList = myIntList.filter { myInt ->
            println(myInt)
            if (myInt == 1) {
                return@filter true
            }
            myInt > 5
        }

        println(myFilterIntList)

        val mySumFun = fun (x : Int, y : Int) : Int {
            return x + y
        }

        val mySumFun2 = fun (x : Int, y : Int) : Int = x + y
        val myMultFun = fun (x : Int, y : Int) : Int = x * y

        println(myOperateFun(5, 10, myMultFun))
        println(myOperateFun(5, 10, mySumFun))
        println(myOperateFun(5,10) { x,y -> x - y })

        myAsyncFun("carlos") {
            println(it)
        }
    }

    private fun myAsyncFun(name : String, hello : (String) -> Unit) {
        val myNewString = "hello $name"
        hello(myNewString)

        thread {
            Thread.sleep(5000)
            hello(myNewString)
        }

        thread {
            Thread.sleep(1000)
            hello(myNewString)
        }

        thread {
            Thread.sleep(7000)
            hello(myNewString)
        }
    }

    private fun myOperateFun(x : Int, y : Int, myFun : (Int,Int)->Int) : Int {
        return myFun(x, y)
    }

    private fun extensions() {
        val myDate = Date()
        println(myDate.customFormat())
        println(MyDate.formatSize)

        var myDateNullable : Date? = null
        println(myDateNullable.customFormat())
        println(myDateNullable.formatSize)
    }

    // destructuring declarations
    private fun destructuringDeclarations() {
        val (name,age,work) = Worker("carlos",26,"programador")
        val (name2, _, work2) = Worker("ana", 18, "disenyadora")
        println("$name,$age,$work")

        val carlos = Worker("carlos",26,"programador")
        println(carlos.component1())
        println(carlos.component2())
        println(carlos.component3())

        val (carlosName,carlosAge,carlosWork) = myWorker()
        println("$carlosName,$carlosAge,$carlosWork")

        val myMap = mapOf(1 to "carlos", 2 to "ana", 3 to "sara")
        for (element in myMap) {
            println("${element.key}, ${element.value}")
            println("${element.component1()}, ${element.component2()}")
        }
        for ((id,name) in myMap) {
            println("${id}, ${name}")
        }
    }

    private fun myWorker() : Worker {
        return Worker("carlos", 26, "programador")
    }

    private var myMap : MyMapList = mutableMapOf()

    private fun typeAliases() {
        var myNewMap : MyMapList = mutableMapOf()
        myNewMap[1] = arrayListOf("carlos", "duarte")
        myNewMap[2] = arrayListOf("duartecorp", "tutoriales")
        myMap = myNewMap
    }

    private fun dataClasses() {
        val carlos = Worker("carlos", 26, "programador")
        carlos.lastWork = "musico"

        val sara = Worker()

        val duarte = Worker("carlos", 26, "programador")

        // equals & hashCode
        if (carlos == duarte) {
            println("son iguales")
        } else {
            println("no son iguales")
        }

        println(carlos.toString())

        val carlos2 = carlos.copy(age = 34)
        println(carlos.toString())
        println(carlos2.toString())

        // componentN
        val (name, age) = duarte
        println(name)
        println(age)
    }

    private fun modificadorDeVisibilidad() {
        val v = Visibilidad()
        v.name = "carlos"
        v.sayMyName()
    }

    private fun interfaces() {
        val gamer = Person("carlos", 26)
        gamer.play()
        gamer.stream()
    }

    private fun herencia() {
        val person = Person("sara", 40)
        val programmer = Programmer("carlos", 26, "kotlin")
        programmer.work()
        programmer.sayLanguage()
        programmer.goToWork()
        programmer.drive()

        val designer = Designer("Ana", 18)
        designer.work()
        designer.goToWork()
    }

    private fun nestedAndInnerClasses() {
        // clase anidad (nested)
        var myNestedClass = MyNestedClass()
        val sum = myNestedClass.sum(10, 5)
        println("suma es $sum")

        val myInnerClass = MyNestedAndInnerClass().MyInnerClass()
        val sumTwo = myInnerClass.sumTwo(10)

    }

    enum class Direction(val dir : Int) {
        NORTH(1),
        SOUTH(-1),
        EAST(1),
        WEST(-1);

        fun description() : String {
            return when (this) {
                NORTH -> "direccion norte"
                SOUTH -> "direccion sur"
                EAST -> "direccion este"
                WEST -> "direccion oeste"
                else -> "no sabemos la direccion"
            }
        }
    }

    private fun enumClasses() {
        // asignacion de valores
        var userDirection : Direction? = null
        println("Direccion: $userDirection")

        userDirection = Direction.NORTH
        println("Direccion: $userDirection")

        userDirection = Direction.EAST
        println("Direccion: $userDirection")

        // propiedades
        println("name: ${userDirection.name}")
        println("ordinal: ${userDirection.ordinal}")

        // funciones
        println(userDirection.description())

        println(userDirection.dir)
    }

    // aqui vamos a hablar de clases
    private fun classes() {
        val myObject = MyClass("carlos",26, arrayOf(MyClass.Language.JAVA,
                                                              MyClass.Language.JAVASCRIPT))
        println(myObject.name)
        myObject.age = 40

        val otherObject = MyClass("sara",35, arrayOf(MyClass.Language.KOTLIN),
                                                        arrayOf(myObject))

        myObject.code()
        otherObject.code()

        println("${myObject.friends?.first()?.name} es amigo de ${otherObject.name}")
    }

    // aqui vamos a hablar de funciones
    private fun funciones() {
        sayHello()
        sayHello()
        sayHello()
        sayMyName("carlos")
        sayMyName("ana")
        sayMyNameAndAge("carlos",12)
        val sum = sumTwoNumbers(4, 5)
        println(sum)
    }

    // funcion simple
    private fun sayHello() {
        println("hola")
    }

    private fun sayMyName(name : String) {
        println("hola soy $name")
    }

    private fun sayMyNameAndAge(name : String, age : Int) {
        println("hola soy $name y mi edad es $age")
    }

    private fun sumTwoNumbers(firstNumber : Int, secondNumber : Int) : Int {
        val sum = firstNumber + secondNumber
        return sum
    }

    // aqui vamos a hablar de seguridad contra nulos (null safety)
    private fun nullSafety() {
        var myString = "carlos"
        //myString = null // error de compilacion
        println(myString)
        var mySafetyString : String? = "carlos null safety"
        mySafetyString = null
        println(mySafetyString)
        mySafetyString = "suscribete"
        println(mySafetyString)

        // safe call
        println(mySafetyString?.length)
        mySafetyString?.let {
            println(it)
        } ?: run {
            println(mySafetyString)
        }
    }

    // aqui vamos a hablar de bucles
    private fun loops() {
        // bucles
        val myArray = listOf("hola","mundo","suscribete")
        val myMap = mutableMapOf("carlos" to 1, "ana" to 2, "pedro" to 3)

        // for
        for (myString in myArray) {
            println(myString)
        }

        for (myElement in myMap) {
            println("${myElement.key}-${myElement.value}")
        }

        for (x in 0..10) {
            println(x)
        }

        for (x in 0 until 10) {
            println(x)
        }

        for (x in 0..10 step 2) {
            println(x)
        }

        for (x in 10 downTo 0 step 3) {
            println(x)
        }

        val myNumericArray = (0..20)
        for (myNum in myNumericArray) {
            println(myNum)
        }

        // while
        var x = 0
        while (x < 10) {
            println(x)
            x += 2
        }
    }

    // aqui vamos a hablar de mapas o diccionarios
    private fun maps() {
        var myMap : Map<String,Int> = mapOf()
        println(myMap)

        // agregar elementos
        myMap = mutableMapOf("carlos" to 50,
                      "ana" to 20,
                      "luis" to 30)
        println(myMap)

        // agregar un solo valor
        myMap["ana"] = 7
        myMap["joel"] = 8
        myMap.put("maria", 90)
        myMap.put("luisa", 100)
        println(myMap)
        myMap.put("marcos", 100)

        // acceso a un dato
        println(myMap["luisa"])

        // eliminar un dato
        myMap.remove("luisa")
        println(myMap)
    }

    // aqui vamos a hablar de arrays
    private fun arrays() {
        val name = "carlos"
        val surname = "duarte"
        val company = "duartecorp"
        val age = "26"

        // creacion de un array
        val myArray = arrayListOf<String>()
        myArray.add(name)
        myArray.add(surname)
        myArray.add(company)
        myArray.add(age)
        myArray.add(age)
        myArray.add(age)
        println(myArray)

        // agregar un conjunto de datos
        myArray.addAll(listOf("hola","bienvenido","al","tutorial"))
        println(myArray)
        val myCompany = myArray[2]
        println(myCompany)

        // modificacion de datos
        myArray[5] = "suscribete"
        println(myArray)

        // eliminar datos
        myArray.removeAt(4)
        println(myArray)

        // recorrer array
        myArray.forEach {
            println(it)
        }

        myArray.count()
        myArray.clear()
        println(myArray.count())
        myArray.first()
        myArray.last()
        myArray.sort()
    }

    // aqui vamos a hablar de la sentencia when
    private fun sentenciaWhen() {
        val country = "mexico"
        when (country) {
            "espanya","mexico","peru","colombia" -> {
                println("idioma espanyol")
            } "USA" -> {
                println("idioma ingles")
            } "francia" -> {
                println("idioma frances")
            } else -> {
                println("idioma desconocido")
            }
        }

        val age = 10
        when (age) {
            0,1,2 -> {
                println("eres un bebe")
            } in 3..10 -> {
                println("eres un ninyo")
            } in 11..17 -> {
                println("adolescente")
            } in 18..69 -> {
                println("adulto")
            } in 70..99 -> {
                println("anciano")
            } else -> {
                println("no hay edad")
            }
        }
    }

    // aqui vamos a hablar de la sentencia if
    private fun sentenciaIf() {
        val myNumber = 10

        if (myNumber < 10) {
            println("$myNumber es menor que 10")
        } else {
            println("$myNumber es mayor que 10")
        }

    }

    private fun tiposDeDatos() {
        // String
        val myString = "hola mundo"
        val myString2 : String = "hola android"
        val myString3 = myString + " " + myString2
        println(myString3)

        // enteros (Byte, Short, Int, Long)
        val myInt : Int = 1
        val myInt2 = 2
        val myInt3 = myInt + myInt2
        println(myInt3)

        // decimales (Float, Double)
        val myDouble : Double = 1.5
        val myFloat : Float = 3.5f
        val myDouble2 = myDouble + myFloat
        println(myDouble2)

        // Boolean (Bool)
        val myBool = true
        val myBool2 : Boolean = false
        // error-> val myBool3 = myBool + myBool2
        println(myBool == myBool2)
        println(myBool && myBool2)
    }

    /*
    * aqui vamos a hablar de variables y constantes
    */
    private fun variablesyconstantes() {
        // variables
        var myFirstVariable = "hola mundo"
        var myFirstNumber = 1
        println(myFirstVariable)
        myFirstVariable = "hola android"
        println(myFirstVariable)

        // no se puede cambiar el tipo de dato
        //myFirstVariable = 1 <--- error

        var mySecondVariable = "suscribanse"
        println(mySecondVariable)
        mySecondVariable = myFirstVariable
        println(mySecondVariable)

        // constantes
        val myFirstConstant = "tutorial"
        println(myFirstConstant)
        val mySecondConstant = myFirstVariable
        println(mySecondConstant)

    }
}