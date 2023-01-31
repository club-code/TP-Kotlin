package conway

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ktx.graphics.use
import space.earlygrey.shapedrawer.ShapeDrawer


class Main : KtxGame<KtxScreen>() {
    override fun create() {
        addScreen(BackgroundScreen())
        setScreen<BackgroundScreen>()
    }
}

class BackgroundScreen : KtxScreen {
    private val batch = SpriteBatch()
    private val shapeDrawer = run {
        val pixmap = Pixmap(1, 1, Pixmap.Format.RGBA8888)
        pixmap.setColor(Color.BLACK)
        pixmap.drawPixel(0, 0)
        val texture = Texture(pixmap) //remember to dispose of later
        pixmap.dispose()
        val region = TextureRegion(texture, 0, 0, 1, 1)
        ShapeDrawer(batch, region).also {
            it.defaultLineWidth = Cell.borderSize
        }
    }
    private val universe = Universe(
        width = Gdx.graphics.width / Cell.cellSize,
        height = Gdx.graphics.height / Cell.cellSize,
        population = 100
    )

    // The list of the lines we'll have to draw
    private val lineList = (0..Gdx.graphics.height step Cell.cellSize)
        .map { Vector2(0F, it.toFloat()) to Vector2(Gdx.graphics.width.toFloat(), it.toFloat()) } +
            (0..Gdx.graphics.width step Cell.cellSize)
                .map { Vector2(it.toFloat(), 0F) to Vector2(it.toFloat(), Gdx.graphics.height.toFloat()) }

    override fun render(delta: Float) {
        clearScreen(red = 1f, green = 1f, blue = 1f)
        batch.use {
            lineList.forEach {
                shapeDrawer.line(it.first, it.second)
            }
//            universe.draw(shapeDrawer)
        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
//            universe.update()
//        }
    }
}
