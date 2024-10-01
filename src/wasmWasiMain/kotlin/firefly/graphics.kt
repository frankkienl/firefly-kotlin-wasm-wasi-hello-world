package firefly

//Screen width in pixels
const val width = 240

//Screen height in pixels
const val height = 160

/**
 * A point on the screen.
 * Typically, the upper-left corner of a bounding box of a shape.
 */
data class Point(var x: Int, var y: Int) {
    fun toSize() : Size {
        return Size(width = x, height = y)
    }
}

operator fun Point.plus(r: Size) = Point(x + r.width, y + r.height)
operator fun Point.minus(r: Size) = Point(x - r.width, y - r.height)

operator fun Point.plus(r: Point) = Point(x + r.x, y + r.y)
operator fun Point.minus(r: Point) = Point(x - r.x, y - r.y)

data class Size(var width: Int, var height: Int) {
    fun toPoint() : Point {
        return Point(x = width, y = height)
    }
}

data class Angle(var a: Float) {

    // Get the angle value in radians
    fun toRadians() : Float {
        return a
    }

    // Get the angle value in degrees
    fun toDegrees() : Float {
        return (a * kotlin.math.PI / 180).toFloat()
    }
}

/**
 * Define an angle in radians where Tau (doubled Pi) is the full circle
 */
fun radiansToAngle(angle: Float) : Angle {
    return Angle(angle)
}

/**
 * Define an angle in radians where 360.0 is the full circle
 */
fun degreesToAngle(angle: Float) : Angle {
    return Angle((angle * kotlin.math.PI / 180).toFloat()) //PI is a Double; Explicit cast to Float
}

data class RGB(var r: Int, var g: Int, var b: Int) {}

enum class DefaultColorsEnum(id: Int, hex: Int) {
    COLOR_NONE(0, 0x000000),
    COLOR_BLACK(1, 0x1A1C2C),
    COLOR_PURPLE(2, 0x5D275D),
    COLOR_RED(3, 0xB13E53),
    COLOR_ORANGE(4, 0xEF7D57),
    COLOR_YELLOW(5, 0xFFCD75),
    COLOR_LIGHT_GREEN(6, 0xA7F070),
    COLOR_GREEN(7, 0x38B764),
    COLOR_DARK_GREEN(8, 0x257179),
    COLOR_DARK_BLUE(9, 0x29366F),
    COLOR_BLUE(10, 0x3B5DC9),
    COLOR_LIGHT_BLUE(11, 0x41A6F6),
    COLOR_CYAN(12, 0x73EFF7),
    COLOR_WHITE(13, 0xF4F4F4),
    COLOR_LIGHT_GRAY(14, 0x94B0C2),
    COLOR_GRAY(15, 0x566C86),
    COLOR_DARK_GRAY(16, 0x333C57),
}

//data class Color(var id: Int) { }
typealias Color = Int

data class Style(
    var fillColor: Color,
    var strokeColor: Color,
    var strokeWidth: Int
)

data class LineStyle(val color: Color, var width: Int) {}

data class Arc(
    var point: Point,
    var diameter: Int,
    var start: Angle,
    var sweep: Angle,
    var style: Style
)