package io.tech.sharding.solo

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = ["io.tech.sharding"])
@EnableJpaRepositories(basePackages = ["io.tech.sharding"])
@PropertySource("classpath:solo/application.properties")
class SoloConfiguration