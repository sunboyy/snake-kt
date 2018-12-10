package controller

import javafx.scene.input.KeyCode
import model.Direction
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue

class KeyboardController {

    private val queue = ConcurrentLinkedQueue<KeyCode>()

    fun addKey(keyCode: KeyCode) {
        if (keyCode == KeyCode.SPACE) GameController.instance.togglePause()
        else queue.add(keyCode)
    }

    fun pollKey(): KeyCode? {
        if (queue.isEmpty()) return null
        return queue.poll()
    }

    companion object {
        val instance = KeyboardController()
    }
}