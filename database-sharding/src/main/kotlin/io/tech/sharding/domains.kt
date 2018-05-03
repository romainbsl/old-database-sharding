package io.tech.sharding

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "cities_directory")
data class CitiesDirectory(
  @Id val id: String,
  val city: String,
  val region: Region
)

@Document(collection = "cities")
data class City(
  @Id val id: String,
  val city: String,
  val region: Region,
  val country: String,
  val area: Double,
  val population: Long
)

enum class Region { EU, US }
