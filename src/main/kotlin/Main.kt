class Pila<T>() {
    private var list = mutableListOf<T>()

    constructor(element: Collection<T>) : this() {
        element.forEach{push(it)}
    }

    fun pop(): Boolean = if (list.size > 0) list.remove(list[0]) else false
    fun push(element: T) = list.add(0, element)

    fun top(): T? = if (list.size > 0) list[0] else null

    fun size(): Int = list.size

    fun isEmpty(): Boolean = list.isEmpty()
    fun isNotEmpty(): Boolean = list.isNotEmpty()

    fun toList(): List<T> = list.toList()
    fun toMutableList(): MutableList<T> = list

    fun toSet(): Set<T> = list.toSet()
    fun toMutableSet(): MutableSet<T> = list.toMutableSet()

    fun set(index:Int,element:T) = list.set(index,element)
    fun get(index: Int):T = list[index]
    fun hasNext():Boolean = list.size > 1

    override fun toString(): String {
        return list.toString()
    }
}

fun main() {
    val nums = listOf("coche", "avión", "tren", "barco")
    val numsReverse = reverse(nums)
    if (!listOf("barco", "tren", "avión", "coche").equals(numsReverse)) println("¡Incorrecto!") else println("¡Correcto!")

    println("Lista al revés: $numsReverse")
}

fun <T> reverse(list: List<T>): List<T> {
    val pila = Pila<T>()
    val iterator = list.iterator()
    val newList = mutableListOf<T>()

    while(iterator.hasNext()) pila.push(iterator.next())
    while (pila.isNotEmpty()){ pila.top()?.let { newList.add(it) }; pila.pop() }
    return newList
}