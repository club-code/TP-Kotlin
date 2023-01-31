package conway

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

/**
 * Represents a Cell in the Universe.
 */
class Cell(val x: Int, val y: Int, val alive: Boolean = true) {
    fun draw(shapeRenderer: ShapeRenderer) {
        shapeRenderer.color = if (alive) Color.BLACK else Color.WHITE
        shapeRenderer.rect(
            x.toFloat() * cellSize,
            y.toFloat() * cellSize,
            cellSize.toFloat(),
            cellSize.toFloat()
        )
    }

    override fun equals(other: Any?) = other is Cell && other.x == x && other.y == y

    companion object {
        val cellSize = 50
        val borderSize = 4f
    }
}