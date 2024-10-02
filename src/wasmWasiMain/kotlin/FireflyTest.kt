import firefly.DefaultColorsEnum
import firefly.Point
import firefly.Style
import firefly.drawTriangle
import shapes.Triangle

@WasmExport
fun main() {
    println("Main()")
    println("Hello World from Kotlin WASM / WASI")
}

@WasmExport
fun boot() {
    println("Boot")

}

@WasmExport
fun update() {
    println("Update")
}

@WasmExport
fun render() {
    println("Render")

    val myTriangle = Triangle(
        Point(60,10),
        Point(40,40),
        Point(80,60),
        Style(
            DefaultColorsEnum.COLOR_GREEN.ordinal,
            DefaultColorsEnum.COLOR_BLUE.ordinal,
            1
        )
    )
    myTriangle.draw()
}

@WasmExport
fun render_line(lineNumber: Int) {
    println("Render_line $lineNumber")
}


