package conway

import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.app.clearScreen

class Main : KtxGame<KtxScreen>() {
    override fun create() {
        addScreen(BackgroundScreen())
        setScreen<BackgroundScreen>()
    }
}

class BackgroundScreen : KtxScreen {
    override fun render(delta: Float) {
        clearScreen(red = 1f, green = 1f, blue = 1f)
    }
}
