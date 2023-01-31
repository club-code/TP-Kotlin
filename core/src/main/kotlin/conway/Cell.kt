package conway

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

/**
 * Represents a Cell in the Universe.
 */
class Cell(val x: Int, val y: Int) {
    fun draw(shapeRenderer: ShapeRenderer) {
        TODO("Draw the shape")
    }

    companion object {
        val cellSize = 50
        val borderSize = 4f
    }
}