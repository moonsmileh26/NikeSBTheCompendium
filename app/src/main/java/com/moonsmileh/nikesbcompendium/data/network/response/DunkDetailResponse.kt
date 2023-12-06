package com.moonsmileh.nikesbcompendium.data.network.response

import com.moonsmileh.nikesbcompendium.domain.model.Box
import com.moonsmileh.nikesbcompendium.domain.model.DunkDetail
import com.moonsmileh.nikesbcompendium.domain.model.Silhouette

data class DunkDetailResponse(
    val silhouette: Silhouette,
    val name: String,
    val description: String,
    val colorway: String,
    val dateReleased: String,
    val boxColor: Box,
    val imageUrl: String,
) {
    fun toDomain(): DunkDetail {
        return DunkDetail(silhouette, name, description, colorway, dateReleased, boxColor, imageUrl)
    }
}
