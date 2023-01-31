package answer

interface MonsterQ2 {
    val name: String
    val size: Double
    val location: String
}

class VampireQ2: MonsterQ2 {
    override val name = "Vampire"
    override val size = 1.8
    override val location = "Transylvania"
}

class GnomeQ2: MonsterQ2 {
    override val name = "Gnome"
    override val size = 0.8
    override val location = "In your garden"
}

class DevJavaQ2: MonsterQ2 {
    override val name = "Java Developer"
    override val size = 1.75
    override val location = "He could be in this very room !"
}