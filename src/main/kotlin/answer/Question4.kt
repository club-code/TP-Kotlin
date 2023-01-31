package answer


enum class SizeQ4 {
    Tall, Medium, Small;
}
abstract class MonsterQ4 (
    val name: String,
    val size: SizeQ4,
    val location: String
) {
    override fun toString() = "Monster($name, $size, $location)"
}

class VampireQ4: MonsterQ4("Vampire", SizeQ4.Tall, "Transylvania")

class GnomeQ4: MonsterQ4("Gnome", SizeQ4.Small, "Your Garden")

class JavaDevQ4: MonsterQ4("Java Developer", SizeQ4.Medium, "He could be in this very room !")