package conway

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
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
            ShapeDrawer(batch, region)
    }
    private val universe = Universe(
        width = Gdx.graphics.width / 50,
        height = Gdx.graphics.height / 50,
        population = 100
    )
    // We'd like 50 pixels per cell.
    override fun render(delta: Float) {
        clearScreen(red = 1f, green = 1f, blue = 1f)
        batch.use {
            universe.draw(shapeDrawer)
        }
    }
}
