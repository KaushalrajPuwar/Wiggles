package com.example.wigglesapp.models

data class UserPreferences(
    val timeDedication: String, // User's available time for pet care
    val sizePreference: String, // Preferred size of the pet
    val childrenAtHome: String, // Information on children at home
    val activityLevel: String, // Preferred activity level of the pet
    val otherPets: String, // Information on other pets at home
    val livingEnvironment: String, // Type of living environment (e.g., apartment, house)
    val reasonForPet: String, // User's reason for wanting a pet
    val groomingPreference: String // Preferred grooming level for the pet
)
