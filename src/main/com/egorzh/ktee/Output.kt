package com.egorzh.ktee

import java.io.*

class Output(arguments: Arguments) {
    private val files = arguments.fileNames.map(::File)

    init {
        if (!arguments.append) {
            files.forEach {
                if (it.exists() && it.isFile) {
                    it.delete()
                }
                it.createNewFile()
            }
        }
    }

    fun println(line: String) {
        kotlin.io.println(line)
        files.forEach { it.appendText(line + "\n") }
    }
}