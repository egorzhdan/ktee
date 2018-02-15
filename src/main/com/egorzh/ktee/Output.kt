package com.egorzh.ktee

import java.io.*

class Output(arguments: Arguments) {
    private val files = arguments.fileNames.map(::File)

    init {
        files.forEach {
            if (!arguments.append) {
                if (it.exists() && it.isFile) {
                    it.delete()
                }
                it.createNewFile()
            }

            require(!it.isDirectory) { "$it is a directory" }
        }
    }

    fun println(line: String) {
        kotlin.io.println(line)
        files.forEach { it.appendText(line + "\n") }
    }
}