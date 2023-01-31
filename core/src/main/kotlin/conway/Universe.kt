package conway

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

/**
 * A Conway universe. It's basically a grid, but we'd rather use a Set.
 */
class Universe(val width: Int, val height: Int, val population: Int) {
    /**
     * Draws all the cells contained in this universe, using the shapeDrawer.
     */
    fun draw(shapeRenderer: ShapeRenderer) {
        TODO("Draw all the cells.")
    }

    /**
     * Updates this universe.
     */
    fun update() {
        TODO("Update the universe")
    }
}