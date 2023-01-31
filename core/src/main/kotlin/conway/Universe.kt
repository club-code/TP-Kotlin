package conway

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

/**
 * A Conway universe. It's basically a grid, but we'd rather use a Set.
 */
class Universe(val width: Int, val height: Int, val population: Int) {
    var cellSet = List<Cell>(population) {
        Cell((0 until width).random(), (0 until height).random())
    }.toSet()
    /**
     * Draws all the cells contained in this universe, using the shapeDrawer.
     */
    fun draw(shapeRenderer: ShapeRenderer) {
        cellSet.forEach { it.draw(shapeRenderer) }
    }

    /**
     * Updates this universe.
     */
    fun update() {
        TODO("Update the universe")
    }
}