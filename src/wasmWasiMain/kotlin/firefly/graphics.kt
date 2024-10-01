package firefly

const val width = 240
const val height = 160

data class Point(var x: Int, var y: Int) {}

data class Size(var width: Int, var height: Int) {}

data class Angle(var a: Float) {}

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

data class Color(var id: Int) {

}

data class Style(
    var fillColor: Color,
    var strokeColor: Color,
    var strokeWidth: Int
)

data class LineStyle(val color: Color, var width: Int){}

fun clearScreen(color: Color) {
    clearScreen(color.id)
}

data class Arc(
    var point: Point,
    var diameter: Int,
    var start: Angle,
    var sweep: Angle,
    var style: Style
)

fun convertPointToSize(point: Point) = Size(point.x, point.y)
fun convertSizeToPoint(size: Size) = Point(size.width, size.height)

operator fun Point.plus(r: Size) = Point(x + r.width, y + r.height)
operator fun Point.minus(r: Size) = Point(x - r.width, y - r.height)

operator fun Point.plus(r: Point) = Point(x + r.x, y + r.y)
operator fun Point.minus(r: Point) = Point(x - r.x, y - r.y)
