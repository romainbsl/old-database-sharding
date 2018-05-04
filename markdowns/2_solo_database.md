# Solo database usage

Here, nothing complicated, as we will take over the simplest case of using a database with Spring.

You may find it redundant with the [Spring Guides](https://spring.io/guides/gs/accessing-data-mysql/).

## Dependencies

First, we need some dependencies, with minimal of `spring-boot-starter-data-jpa`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

In my case I choose to use MySQL, so I also need `mysql-connector-java`.

## Configuration

Once, I have set the dependencies, I need some configuration to tell Spring what I want him to load in the context.

> src/resources/solo/application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3301/centralshard
spring.datasource.username=root
spring.datasource.password=
```

```kotlin
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = ["io.tech.sharding"])
@EnableJpaRepositories(basePackages = ["io.tech.sharding"])
@PropertySource("classpath:solo/application.properties")
class SoloConfiguration
```

## Usage (tests)

```kotlin
@RunWith(SpringRunner::class)
@SpringBootTest(classes = [SoloConfiguration::class])
class SoloDatabaseConfigurationTest { 
// { autofold
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
// }
 }
```

