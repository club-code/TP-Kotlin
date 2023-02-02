package answer


sealed class MonsterQ6 (
    val name: String,
    val size: SizeQ4,
    val location: String
): Comparable<MonsterQ6>  {
    override fun compareTo(other: MonsterQ6): Int =
        if (other.size == size) other.name.compareTo(name)
        else size.compareTo(other.size)
    override fun toString() = "Monster($name, $size, $location)"
}