package com.tournament.kotlingraphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing

@SpringBootApplication
@EnableMongoAuditing
class KotlinGraphqlApplication

fun main(args: Array<String>) {
	runApplication<KotlinGraphqlApplication>(*args)
}
