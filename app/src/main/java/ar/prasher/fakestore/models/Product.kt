package ar.prasher.fakestore.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("Product")
data class Product(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)