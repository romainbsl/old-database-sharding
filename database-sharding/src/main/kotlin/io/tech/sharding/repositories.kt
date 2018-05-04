package io.tech.sharding

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface CitiesDirectoryRepository : JpaRepository<CitiesDirectory, Int>
@Repository interface CityRepository : JpaRepository<City, Int>