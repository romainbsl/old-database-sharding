package io.tech.sharding.solo

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories("io.tech.sharding")
@PropertySource("classpath:solo/application.properties")
class SoloConfiguration