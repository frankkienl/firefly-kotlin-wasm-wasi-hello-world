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
}

@WasmExport
fun render_line(lineNumber: Int) {
    println("Render_line $lineNumber")
}


