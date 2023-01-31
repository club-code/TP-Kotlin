package conway

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

/**
 * A Conway universe. It's basically a grid, but we'd rather use a Set.
 */
class Universe(val width: Int, val height: Int, val population: Int) {
    var cellMap = List(population) {
        val coordinates = (0 until width).random() to (0 until height).random()
        coordinates to Cell(coordinates.first, coordinates.second)
    }.toMap().toMutableMap()

    /**
     * Draws all the cells contained in this universe, using the shapeDrawer.
     */
    fun draw(shapeRenderer: ShapeRenderer) {
        cellMap.forEach { it.value.draw(shapeRenderer) }
    }

    /**
     * Updates this universe.
     */
    fun update() {
        val countMap = mutableMapOf<Pair<Int, Int>, Int>()
        cellMap.forEach { (coordinates, cell) ->
            cell.getNeighbours().forEach {
                countMap[it] = 1 + (countMap[it] ?: 0)
            }
        }
        val newMap = (countMap.filter { it.value == 3 }.keys +
                cellMap.filterValues { it.alive }.keys.filter { countMap[it] == 2 })
            .associateWith { Cell(it.first, it.second) }
        cellMap = newMap.filterKeys { it.first in 0..width && it.second in 0..height }
            .toMutableMap()
    }

    /**
     * Switches the state of a cell.
     */
    fun switch(x:Int, y:Int) {
        if (cellMap.containsKey(x to y)) {
            cellMap[x to y]!!.alive = !cellMap[x to y]!!.alive
        } else {
            cellMap[x to y] = Cell(x, y)
        }
    }
}