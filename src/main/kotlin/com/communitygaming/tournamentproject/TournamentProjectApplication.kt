package com.communitygaming.tournamentproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class TournamentProjectApplication

fun main(args: Array<String>) {
	runApplication<TournamentProjectApplication>(*args)
}
