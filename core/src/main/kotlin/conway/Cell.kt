package conway

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

/**
 * Represents a Cell in the Universe.
 */
sealed class Cell(val x: Int, val y: Int) {
    abstract val color: Color
    fun draw(shapeRenderer: ShapeRenderer) {
        shapeRenderer.color = color
        shapeRenderer.rect(
            x.toFloat() * cellSize,
            y.toFloat() * cellSize,
            cellSize.toFloat(),
            cellSize.toFloat()
        )
    }

    fun getNeighbours() = listOf(
        x - 1 to y - 1, x - 1 to y, x - 1 to y + 1,
        x to y - 1, x to y + 1,
        x + 1 to y - 1, x + 1 to y, x + 1 to y + 1
    )

    override fun equals(other: Any?) = other is Cell && other.x == x && other.y == y
    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    companion object {
        const val cellSize = 50
        const val borderSize = 4f
    }
}

class Dirt(x: Int, y: Int): Cell(x,y) {
    override val color: Color = Color.BROWN
}

class Water(x: Int, y: Int): Cell(x,y) {
    override val color: Color = Color.BLUE
}

class Mud(x: Int, y: Int): Cell(x,y) {
    override val color: Color = Color.GRAY
}
