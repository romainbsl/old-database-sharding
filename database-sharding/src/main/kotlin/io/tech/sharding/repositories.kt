package io.tech.sharding

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository interface CitiesDirectoryRepository : MongoRepository<CitiesDirectory, String>
@Repository interface CityRepository : MongoRepository<City, String>