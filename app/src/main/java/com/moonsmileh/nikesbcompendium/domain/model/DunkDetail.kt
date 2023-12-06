package com.moonsmileh.nikesbcompendium.domain.model

data class DunkDetail(
    val silhouette: Silhouette,
    val name: String,
    val description: String,
    val colorway: String,
    val dateReleased: String,
    val boxColor: Box,
    val imageUrl: String
)
