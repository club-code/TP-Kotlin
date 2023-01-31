package conway

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

/**
 * Represents a Cell in the Universe.
 */
class Cell(val x: Int, val y: Int, var alive: Boolean = true) {
    fun draw(shapeRenderer: ShapeRenderer) {
        shapeRenderer.color = if (alive) Color.BLACK else Color.WHITE
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

    companion object {
        const val cellSize = 50
        const val borderSize = 4f
    }
}