@file:JvmName("Lwjgl3Launcher")

package conway.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import conway.Main

/** Launches the desktop (LWJGL3) application. */
fun main() {
    Lwjgl3Application(Main(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("Conway's Game of Life")
        setWindowedMode(640, 480)
        setWindowIcon("club_code.png")
    })
}
