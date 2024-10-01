Go to Kotlin
============
Not gonna type everything, just copy-paste and change using regex / find-and-replace.

func
----
Replace `func` with `external fun`

wasmimport
----------
Replace
`//go:wasmimport graphics draw_point`
with
`@WasmImport("graphics","draw_point")`

Regex:
```
\/\/go:wasmimport (\w+) (\w+)
@WasmImport("$1","$2")
```

https://regex101.com/

