package firefly

import kotlin.math.sqrt

// The lowest possible value for Pad.x
const val padMinX = -1000

// The lowest possible value for Pad.y
const val padMinY = -1000

// The highest possible value for Pad.x
const val padMaxX = 1000

// The highest possible value for Pad.y
const val padMaxY = 1000

// The minimum X or Y value when converting Pad into DPad
// for the direction to be considered pressed.
// We do that to provide a dead zone in the middle of the pad.
const val dPadThreshold = 100


/**
 * A finger position on the touchpad.
 * Both X and Y are somewhere the range between -1000 and 1000 (both ends included).
 * The 1000 X is on the right, the 1000 Y is on the top.
 */
data class Pad(val x: Int, val y: Int) {

    /**
     * The distance from the pad center to the touch point
     */
    fun toRadius(): Float {
        // Pythagoras
        // distance = sqrt ( a^2 + b^2 );
        val r = (x * x) + (y * y)
        return sqrt(r.toFloat())
    }

    /**
     * The angle of the [polar coordinate] of the touch point.
     * [polar coordinate]: https://en.wikipedia.org/wiki/Polar_coordinate_system
     */
    fun toAzimuth(): Angle {
        val r = (kotlin.math.PI / 2 * kotlin.math.atan2(x.toFloat(), y.toFloat())).toFloat()
        return radiansToAngle(r)
    }

    /**
     * Convert the [Pad] into a [Point].
     */
    fun toPoint(): Point {
        return Point(x, y)
    }

    /**
     * Convert the [Pad] into a Size.
     */
    fun toSize(): Size {
        return Size(x, y)
    }

    /**
     * Convert the [Pad] into [DPad].
     */
    fun toDPad(): DPad {
        return DPad(
            left = x <= -dPadThreshold,
            right = x >= dPadThreshold,
            up = y <= -dPadThreshold,
            down = y >= dPadThreshold
        )
    }
}

/**
 * DPad-like representation of the [Pad].
 *
 * Constructed with [Pad.toDPad]. Useful for simple games and ports.
 * The middle of the pad is a "dead zone" pressing which will not activate any direction.
 *
 * Invariant: it's not possible for opposite directions (left and right, or down and up)
 * to be active at the same time. However, it's possible for neighboring directions
 * (like up and right) to be active at the same time if the player presses a diagonal.
 */
data class DPad(var left: Boolean, var right: Boolean, var up: Boolean, var down: Boolean) {
    /**
     * Given the old state, get directions that were not pressed but are pressed now.
     */
    fun justPressed(old: DPad): DPad {
        return DPad(
            left = left && !old.left,
            right = right && !old.right,
            up = up && !old.up,
            down = down && !old.down
        )
    }

    /**
     * Given the old state, get directions that were pressed but aren't pressed now.
     */
    fun justReleased(old: DPad): DPad {
        return DPad(
            left = !left && old.left,
            right = !right && old.right,
            up = !up && old.up,
            down = !down && old.down
        )
    }

    /**
     * Given the old state, get directions that were pressed and are still pressed now.
     */
    fun held(old: DPad): DPad {
        return DPad(
            left = left && old.left,
            right = right && old.right,
            up = up && old.up,
            down = down && old.down
        )
    }
}

/**
 * State of the buttons.
 */
data class Buttons(
    // if "A" button is pressed.
    var a: Boolean,
    // if "B" button is pressed.
    var b: Boolean,
    // if "X" button is pressed.
    var x: Boolean,
    // if "Y" button is pressed.
    var y: Boolean,
    // if "Menu" is pressed.
    // For single player games, the button press is always intercepted by the runtime.
    var menu: Boolean
) {
    //TODO: implement functions
}