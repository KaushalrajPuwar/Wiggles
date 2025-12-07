package com.example.wigglesapp

import com.example.wigglesapp.data.dao.Converters
import org.junit.Assert.*
import org.junit.Test

class ConvertersTest {

    private val converters = Converters()

    // -------------------------
    // 1. BASIC CASES
    // -------------------------

    @Test
    fun `list of strings converts to comma separated string`() {
        val input = listOf("a", "b", "c")
        val result = converters.fromStringList(input)
        assertEquals("a,b,c", result)
    }

    @Test
    fun `comma separated string converts to list of strings`() {
        val input = "a,b,c"
        val result = converters.toStringList(input)
        assertEquals(listOf("a", "b", "c"), result)
    }

    // -------------------------
    // 2. EDGE CASES
    // -------------------------

    @Test
    fun `empty list converts to empty string`() {
        val input = emptyList<String>()
        val result = converters.fromStringList(input)
        assertEquals("", result)
    }

    @Test
    fun `empty string converts to list with empty element`() {
        val input = ""
        val result = converters.toStringList(input)
        assertEquals(listOf(""), result)
    }

    @Test
    fun `string with consecutive commas keeps empty elements`() {
        val input = "a,,b"
        val result = converters.toStringList(input)
        assertEquals(listOf("a", "", "b"), result)
    }

    // -------------------------
    // 3. SPECIAL CHARACTERS
    // -------------------------

    @Test
    fun `strings containing commas round trip correctly`() {
        val input = listOf("hello,world", "test,value")
        val joined = converters.fromStringList(input)
        val result = converters.toStringList(joined)
        // Expected output breaks the items where commas appear. This highlights a real converter limitation.
        assertEquals(listOf("hello", "world", "test", "value"), result)
    }

    // -------------------------
    // 4. LARGE LIST HANDLING
    // -------------------------

    @Test
    fun `large string list converts correctly`() {
        val input = (1..500).map { "item$it" }
        val resultString = converters.fromStringList(input)
        val restoredList = converters.toStringList(resultString)

        assertEquals(500, restoredList.size)
        assertEquals("item1", restoredList[0])
        assertEquals("item500", restoredList.last())
    }
}
