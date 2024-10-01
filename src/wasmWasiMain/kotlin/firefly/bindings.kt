package firefly

@WasmImport("graphics", "clear_screen")
external fun clearScreen(c: Int)

@WasmImport("graphics", "set_color")
external fun setColor(c: Int, r: Int, g: Int, b: Int)

@WasmImport("graphics", "draw_point")
external fun drawPoint(x: Int, y: Int, c: Int)

@WasmImport("graphics", "draw_line")
external fun drawLine(x1: Int, y1: Int, x2: Int, y2: Int, c: Int, strokeWidth: Int)

@WasmImport("graphics", "draw_rect")
external fun drawRect(x: Int, y: Int, width: Int,height: Int, fillColor: Int, strokeColor: Int, strokeWidth: Int)

@WasmImport("graphics", "draw_rounded_rect")
external fun drawRoundedRect(x: Int, y: Int, width: Int, height: Int, cornerWidth: Int, cornerHeight: Int, fillColor: Int, strokeColor: Int, strokeWidth: Int)

@WasmImport("graphics", "draw_circle")
external fun drawCircle(x: Int, y: Int, d: Int, fillColor: Int, strokeColor: Int, strokeWidth: Int)

@WasmImport("graphics", "draw_ellipse")
external fun drawEllipse(x: Int, y: Int, width: Int,height: Int, fillColor: Int, strokeColor: Int, strokeWidth: Int)

@WasmImport("graphics", "draw_triangle")
external fun drawTriangle(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int, fillColor: Int, strokeColor: Int, strokeWidth: Int)

@WasmImport("graphics", "draw_arc")
external fun drawArc(x: Int, y: Int, d: Int, ast: Float, asc: Float, fillColor: Int, strokeColor: Int, strokeWidth: Int)

@WasmImport("graphics", "draw_sector")
external fun drawSector(x: Int, y: Int, d: Int, ast: Int, asc: Int, fillColor: Int, strokeColor: Int, strokeWidth: Int)

//@WasmImport("graphics","draw_text")
//external fun drawText(
//    textPtr unsafe.Pointer: , textLen uint32,
//fontPtr unsafe.Pointer, fontLen uint32,
//x, y, color int32,
//)

//@WasmImport("graphics","draw_image")
//external fun drawImage(ptr unsafe.Pointer, len uint32, x, y int32)
//
//@WasmImport("graphics","draw_sub_image")
//external fun drawSubImage(
//    ptr unsafe.Pointer, len uint32,
//x, y, subX, subY int32, subWidth, subHeight uint32,
//)

// -- INPUT -- //

@WasmImport("input", "read_pad")
external fun readPad(player: Int): Int

@WasmImport("input", "read_buttons")
external fun readButtons(player: Int): Int

// -- FS -- //

//@WasmImport("fs", "get_rom_file_size")
//external fun getRomFileSize(pathPtr unsafe.Pointer, pathLen uint32) uint32
//
//@WasmImport("fs", "load_rom_file")
//external fun loadRomFile(
//    pathPtr unsafe.Pointer, pathLen uint32,
//bufPtr unsafe.Pointer, bufLen uint32,
//) uint32
//
//@WasmImport("fs", "get_file_size")
//external fun getFileSize(pathPtr unsafe.Pointer, pathLen uint32) uint32
//
//@WasmImport("fs", "load_file")
//external fun loadFile(
//    pathPtr unsafe.Pointer, pathLen uint32,
//bufPtr unsafe.Pointer, bufLen uint32,
//) uint32
//
//@WasmImport("fs", "dump_file")
//external fun dumpFile(
//    pathPtr unsafe.Pointer, pathLen uint32,
//bufPtr unsafe.Pointer, bufLen uint32,
//) uint32
//
//@WasmImport("fs", "remove_file")
//external fun removeFile(pathPtr unsafe.Pointer, pathLen uint32) uint32

// -- NET -- //

@WasmImport("net", "get_me")
external fun getMe(): Int

@WasmImport("net", "get_peers")
external fun getPeers(): Int

// -- MISC -- //

//@WasmImport("misc", "log_debug")
//external fun logDebug(ptr unsafe.Pointer, len uint32)
//
//@WasmImport("misc", "log_error")
//external fun logError(ptr unsafe.Pointer, len uint32)

@WasmImport("misc", "set_seed")
external fun setSeed(seed: Int)

@WasmImport("misc", "get_random")
external fun getRandom(): Int

@WasmImport("misc", "restart")
external fun restart()

@WasmImport("misc", "quit")
external fun quit()