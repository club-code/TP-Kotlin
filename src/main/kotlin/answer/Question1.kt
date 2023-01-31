package answer

class MonsterQ1(val name: String, val size: Double, val location: String) {
    override fun toString() = "Monster($name, $size, $location)"
}

// Deux solutions pour que le println fonctionne:
// Faire de la classe une dataClass (rajouter le mot clef data devant class)
// Ou définir une méthode toString()
// C'est cette deuxième méthode qu'on a fait ici