package caiofa.com.beersmvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Beer (
    val id: Int, @field:PrimaryKey
    val name: String,
    val tagline: String,
    val first_brewed: String,
    val description: String,
    val image_url: String,
    val brewers_tips: String  )