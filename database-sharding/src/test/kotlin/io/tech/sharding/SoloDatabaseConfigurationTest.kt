package io.tech.sharding

import io.tech.sharding.solo.SoloConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [SoloConfiguration::class])
class SoloDatabaseConfigurationTest {

  @Autowired
  lateinit var citiesDirectoryRepository: CitiesDirectoryRepository

  @Test
  fun `context loads`() {
  }

  @Test
  fun `directory contains 15 cities`() {
    assertThat(citiesDirectoryRepository.count())
      .isNotNull()
      .isEqualTo(15)
  }



}
