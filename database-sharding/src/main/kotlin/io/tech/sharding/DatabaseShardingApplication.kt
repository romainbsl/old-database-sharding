package io.tech.sharding

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DatabaseShardingApplication

fun main(args: Array<String>) {
  runApplication<DatabaseShardingApplication>(*args)
}
