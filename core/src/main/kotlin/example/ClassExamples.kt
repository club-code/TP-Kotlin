package example

import kotlin.math.sqrt

class Point(val x: Int, val y: Int) : Comparable<Point> {
    // Comparable<T> est une interface qui veux essentiellement dire
    // Qu'il existe une relation d'ordre totale entre notre classe et T
    // Elle demande la définition de compareTo
    override fun compareTo(other: Point) = norm.compareTo(other.norm)

    // sqrt ne prends que des Double ou des Float en argument.
    val norm = sqrt((x * x + y * y).toDouble())

    // Remarquez que je pourrais faire de cet attribut une fonction
    // Mais je préfère en faire un attribut calculé au moment où il est appellé
    // NB: ça ne peux pas être un attribut calculé à l'initialisation !
    // Problème de récurrence
    val neighours: Set<Point> by lazy {
        setOf(
            Point(x + 1, y),
            Point(x, y + 1),
            Point(x - 1, y),
            Point(x, y - 1)
        )
    }

    override fun toString() = "example.Point($x,$y)"

    //override fun equals(other: Any?) = other is example.Point && other.x == x && other.y == y
}


sealed interface BureauClubCode {
    val based: Boolean
    fun isOld() = when (this) {
        is BureauActuel -> false
        is Vieux -> true
    }
    // No need for else branch !!!
    // All the sealed class implementations are known at compile-time.
}
enum class BureauActuel(override val based: Boolean): BureauClubCode {
    Loulou(true), JauttaroCoudjau(true), BipBip(false);
}
class Vieux(val name: String): BureauClubCode {
    override val based = true
}

fun main() {
    val setOfPoints = setOf(
        Point(-10, 10),
        Point(0, 0),
        Point(1, 0),
        Point(1, 2),
        Point(-5, 3),
    ).map { it.neighours + it }
        .flatten()
        .toSet()
        .sorted()
    println(setOfPoints)
    // Notice that there are some points that are equals
    // That's because by default, equality on Kotlin is based on memory
    // Uncomment line 27 and see them disappear
    // Or you can make the example.Point class a DataClass (you'd thus be able to remove the example.Point::toString method)
}