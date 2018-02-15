package com.egorzh.ktee

import kotlin.test.*

class ArgumentsTest {
    @Test
    fun `no args`() {
        val a = Arguments(emptyArray())
        assertFalse(a.append)
        assertTrue(a.fileNames.isEmpty())
    }

    @Test
    fun `single file`() {
        val files = arrayOf("file.txt")
        val a = Arguments(files)
        assertFalse(a.append)
        assertEquals(files.toList(), a.fileNames)
    }

    @Test
    fun `single file append`() {
        val files = arrayOf("-a", "file.txt")
        val a = Arguments(files)
        assertTrue(a.append)
        assertEquals(files.drop(1), a.fileNames)
    }

    @Test
    fun `single file append ignore interrupt`() {
        val files = arrayOf("-a", "-i", "file.txt")
        val a = Arguments(files)
        assertTrue(a.append)
        assertTrue(a.ignoreInterrupt)
        assertEquals(files.drop(2), a.fileNames)
    }

    @Test
    fun `two files because of args order`() {
        val files = arrayOf("file.txt", "-a")
        val a = Arguments(files)
        assertFalse(a.append)
        assertEquals(files.toList(), a.fileNames)
    }
}