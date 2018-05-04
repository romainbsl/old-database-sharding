package io.tech.sharding

import javax.persistence.*

@Entity
@Table(name = "cities_directory")
data class CitiesDirectory(
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  val id: Int = -1,
  val city: String = "",
  @Enumerated(EnumType.STRING)
  val region: Region = Region.UNKNOWN
)

@Entity
@Table(name = "cities")
data class City(
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  val id: Int = -1,
  val city: String = "",
  @Enumerated(EnumType.STRING)
  val region: Region = Region.UNKNOWN,
  val country: String = "",
  val area: Double = 0.0,
  val population: Long = 0
)

enum class Region { EU, US, UNKNOWN }
