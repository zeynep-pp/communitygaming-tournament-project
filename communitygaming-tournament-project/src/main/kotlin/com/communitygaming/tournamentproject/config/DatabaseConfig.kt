package com.communitygaming.tournamentproject.config


import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.core.convert.converter.Converter
import org.springframework.data.auditing.DateTimeProvider
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import java.time.Clock
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.*


@Configuration(proxyBeanMethods = false)
@EnableMongoRepositories("com.communitygaming.tournamentproject.repository")
@Import(value = [MongoAutoConfiguration::class])
@EnableMongoAuditing(
    auditorAwareRef = "springSecurityAuditorAware")
class DatabaseConfig {

    @Bean
    fun mongoCustomConversions() =
        MongoCustomConversions(
            mutableListOf<Converter<*, *>>(
            )
        )


}
