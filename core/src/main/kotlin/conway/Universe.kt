package conway

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import kotlin.reflect.typeOf

/**
 * A Conway universe. It's basically a grid, but we'd rather use a Set.
 */
class Universe(val width: Int, val height: Int, val population: Int) {
    var cellMap = mutableMapOf<Pair<Int, Int>, Cell>()

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
        val coordinatesToUpdate = cellMap.keys + cellMap.values.map { it.getNeighbours() }.flatten()
        val newSet = coordinatesToUpdate
            .filter { it.first in 0..width && it.second in 0..height }
            .mapNotNull { (x, y) ->
                when (val cell = cellMap[x to y]) {
                    null -> when (cellMap[x to y + 1]) {
                        is Water -> Water(x, y)
                        is Mud -> Dirt(x, y)
                        else -> null
                    }

                    is Dirt -> {
                        if (cell.getNeighbours().count { cellMap[it] is Water } == 1)
                            Mud(x, y)
                        else cell
                    }

                    is Water -> if (cellMap[x to y - 1] == null) null
                    else if (cell.getNeighbours().count { cellMap[it] is Dirt } >= 1) null
                    else cell

                    is Mud -> if (cell.getNeighbours().count { cellMap[it] is Water } >= 1) cell
                    else Dirt(x, y)
                }
            }
        cellMap = newSet.associateBy { (it.x to it.y) }.toMutableMap()
    }

    /**
     * Switches the state of a cell.
     */
    fun switch(x: Int, y: Int) {
        when (cellMap[x to y]) {
            null -> cellMap[x to y] = Dirt(x, y)
            is Dirt -> cellMap[x to y] = Water(x, y)
            is Water -> cellMap[x to y] = Mud(x, y)
            is Mud -> cellMap.remove(x to y)
        }
    }
}