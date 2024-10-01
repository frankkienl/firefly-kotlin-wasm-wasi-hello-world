package shapes

import firefly.*

interface Shape {
    fun draw()
}

data class Line(val a: Point, var b: Point, var style: Style) : Shape {
    override fun draw() {
        drawLine(
            a.x, a.y,
            b.x, b.y,
            style.strokeColor.id,
            style.strokeWidth
        )
    }
}

data class Rect(var point: Point, var size: Size, var style: Style) : Shape {
    override fun draw() {
        drawRect(
            point.x, point.y,
            size.width, size.height,
            style.fillColor.id, style.strokeColor.id, style.strokeWidth
        )
    }
}

data class RoundedRect(var point: Point, var size: Size, var corner: Size, var style: Style) : Shape {
    override fun draw() {
        drawRoundedRect(
            point.x, point.y,
            size.width, size.height,
            corner.width, corner.height,
            style.fillColor.id, style.strokeColor.id, style.strokeWidth
        )
    }
}

data class Circle(var point: Point, var diameter: Int, var style: Style) : Shape {
    override fun draw() {
        drawCircle(
            point.x, point.y,
            diameter,
            style.fillColor.id, style.strokeColor.id, style.strokeWidth
        )
    }
}

data class Ellipse(var point: Point, var size: Size, var style: Style) : Shape {
    override fun draw() {
        drawEllipse(
            point.x, point.y,
            size.width, size.height,
            style.fillColor.id, style.strokeColor.id, style.strokeWidth
        )
    }
}

data class Triangle(var a: Point, var b: Point, var c: Point, var style: Style) : Shape {
    override fun draw() {
        drawTriangle(
            a.x, a.y,
            b.x, b.y,
            c.x, c.y,
            style.fillColor.id, style.strokeColor.id, style.strokeWidth
        )
    }
}

data class Arc(var point: Point, var diameter: Int, val start: Angle, var sweep: Angle, var style: Style) : Shape {
    override fun draw() {
        drawArc(
            point.x, point.y,
            diameter,
            start.a,
            sweep.a,
            style.fillColor.id, style.strokeColor.id, style.strokeWidth
        )
    }
}

data class Sector(var point: Point, var diameter: Int, var start: Angle, var sweep: Angle, var style: Style) : Shape {
    override fun draw() {
        drawSector(
            point.x, point.y,
            diameter,
            start.a, sweep.a,
            style.fillColor.id, style.strokeColor.id, style.strokeWidth
        )
    }
}