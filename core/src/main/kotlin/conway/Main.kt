package conway

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ktx.graphics.use


class Main : KtxGame<KtxScreen>() {
    override fun create() {
        addScreen(BackgroundScreen())
        setScreen<BackgroundScreen>()
    }
}

class BackgroundScreen : KtxScreen {
    private val shapeRenderer = ShapeRenderer()
    private val universe = Universe(
        width = Gdx.graphics.width / Cell.cellSize,
        height = Gdx.graphics.height / Cell.cellSize,
        population = 100
    )

    // The list of the lines we'll have to draw
    private val lineList = (0..Gdx.graphics.height step Cell.cellSize)
        .map { (0F to it.toFloat() - Cell.borderSize / 2) to (Gdx.graphics.width.toFloat() to Cell.borderSize) } +
            (0..Gdx.graphics.width step Cell.cellSize)
                .map { (it.toFloat() - Cell.borderSize / 2 to 0F) to (Cell.borderSize to Gdx.graphics.height.toFloat()) }

    override fun render(delta: Float) {
        clearScreen(red = 1f, green = 1f, blue = 1f)
        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            shapeRenderer.color = Color.PURPLE
            lineList.forEach {
                shapeRenderer.rect(it.first.first, it.first.second, it.second.first, it.second.second)
            }
//            universe.draw(shapeRenderer)
        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
//            universe.update()
//        }
    }
}
