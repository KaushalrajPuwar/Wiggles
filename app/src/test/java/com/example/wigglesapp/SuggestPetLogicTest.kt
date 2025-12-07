package com.example.wigglesapp

import com.example.wigglesapp.models.UserPreferences
import com.example.wigglesapp.utils.suggestPets
import org.junit.Assert.assertEquals
import org.junit.Test

class SuggestPetLogicTest {

    // Helper to avoid repeating 8 fields everywhere
    private fun prefs(
        time: String,
        size: String,
        children: String
    ): UserPreferences {
        return UserPreferences(
            timeDedication = time,
            sizePreference = size,
            childrenAtHome = children,
            activityLevel = "Low",            // placeholder
            otherPets = "None",               // placeholder
            livingEnvironment = "Apartment",  // placeholder
            reasonForPet = "Companionship",   // placeholder
            groomingPreference = "Low"        // placeholder
        )
    }

    @Test
    fun `less than 1 hour, small, no children → id 11`() {
        val prefs = prefs(
            time = "Less than 1 hour",
            size = "Small",
            children = "No children"
        )

        val result = suggestPets(prefs)

        assertEquals(1, result.size)
        assertEquals(11, result[0].id)
    }

    @Test
    fun `1-2 hours, small, no children → id 12`() {
        val prefs = prefs(
            time = "1-2 hours",
            size = "Small",
            children = "No children"
        )

        val result = suggestPets(prefs)

        assertEquals(1, result.size)
        assertEquals(12, result[0].id)
    }

    @Test
    fun `fallback path yields valid id between 1 and 30`() {
        val prefs = prefs(
            time = "UNKNOWN",
            size = "UNKNOWN",
            children = "UNKNOWN"
        )

        val result = suggestPets(prefs)

        assertEquals(1, result.size)
        val id = result[0].id
        assert(id in 1..30)
    }
}
