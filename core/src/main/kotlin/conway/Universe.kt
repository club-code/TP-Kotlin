package conway

import space.earlygrey.shapedrawer.ShapeDrawer

/**
 * A Conway universe. It's basically a grid, but we'd rather use a Set.
 */
class Universe(val width: Int, val height: Int, val population: Int) {
    /**
     * Draws all the cells contained in this universe, using the shapeDrawer.
     */
    fun draw(shapeDrawer: ShapeDrawer) {
        TODO("Draw all the cells.")
    }

    /**
     * Updates this universe.
     */
    fun update() {
        TODO("Update the universe")
    }
}