package com.example.wigglesapp.models

// Data class representing a pet with various attributes

data class Pet(
    val id: Int, // Unique identifier for the pet
    val name: String,  // Pet's name
    val breed: String, // Pet's breed
    val imageUrl: String, // URL to the pet's image
    val gender: String = "", // Pet's gender (optional, default empty)
    val size: String = "", // Pet's size (optional, default empty)
    val characteristics: String = "", // Pet's characteristics (optional, default empty)
    val about: String = ""  // Additional information about the pet (optional, default empty)
)
