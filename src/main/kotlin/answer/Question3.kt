package answer

abstract class MonsterQ3 (
    val name: String,
    val size: Double,
    val location: String
) {
    override fun toString() = "Monster($name, $size, $location)"
}

class VampireQ3: MonsterQ3("Vampire", 1.8, "Transylvania")

class GnomeQ3: MonsterQ3("Gnome", 0.8, "Your Garden")

class JavaDevQ3: MonsterQ3("Java Developer", 1.75, "He could be in this very room !")