package com.communitygaming.tournamentproject.config


import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RestTemplateConfiguration(
)  {
    @Bean
    fun graphQLTestTemplate(): TestRestTemplate? {
        return TestRestTemplate()
    }

}
