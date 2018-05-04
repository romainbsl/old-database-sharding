package io.tech.sharding.solo

import io.tech.sharding.CitiesDirectoryRepository
import io.tech.sharding.Region
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
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

  @Test
  fun `directory contains 8 EU cities`() {
    assertThat(citiesDirectoryRepository.findAll())
      .isNotNull
      .isNotEmpty
      .filteredOn { it.region == Region.EU }
      .hasSize(8)
  }

  @Test
  fun `directory contains 7 US cities`() {
    assertThat(citiesDirectoryRepository.findAll())
      .isNotNull
      .isNotEmpty
      .filteredOn { it.region == Region.US }
      .hasSize(7)
  }
}
