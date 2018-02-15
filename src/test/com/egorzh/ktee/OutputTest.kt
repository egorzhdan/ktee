package com.egorzh.ktee

import java.io.File
import kotlin.test.*

class OutputTest {
    @AfterTest
    fun tearDown() {
        arrayOf("_test1.txt", "_test2.txt").map(::File).forEach {
            if (it.exists() && it.isFile) {
                it.delete()
            }
        }
    }

    @Test
    fun `two files`() {
        val out = Output(Arguments(arrayOf("_test1.txt", "_test2.txt")))
        out.println("test")
        out.println("test2")

        val lines1 = File("_test1.txt").readLines()
        val lines2 = File("_test2.txt").readLines()

        val expected = listOf("test", "test2")
        assertEquals(expected, lines1)
        assertEquals(expected, lines2)
    }
}