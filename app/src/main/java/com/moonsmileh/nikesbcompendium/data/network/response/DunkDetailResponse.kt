package com.moonsmileh.nikesbcompendium.data.network.response

import com.moonsmileh.nikesbcompendium.domain.model.Box
import com.moonsmileh.nikesbcompendium.domain.model.DunkDetail
import com.moonsmileh.nikesbcompendium.domain.model.Silhouette

data class DunkDetailResponse(
    val id: String,
    val silhouette: String,
    val name: String,
    val description: String,
    val colorway: String,
    val releasedDate: String,
    val boxColor: String,
    val imageUrl: String,
) {
    fun toDomain(): DunkDetail {
        return DunkDetail(
            id,
            silhouette,
            name,
            description,
            colorway,
            releasedDate,
            boxColor,
            imageUrl
        )
    }
}
