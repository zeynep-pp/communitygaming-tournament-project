package com.communitygaming.tournamentproject.graphql.resolver.query

import com.graphql.spring.boot.test.GraphQLTestTemplate
import com.communitygaming.tournamentproject.IntegrationTest
import com.communitygaming.tournamentproject.domain.User
import com.communitygaming.tournamentproject.repository.UserRepository
import com.communitygaming.tournamentproject.utils.UserUtils.Companion.DEFAULT_USERNAME
import com.communitygaming.tournamentproject.utils.UserUtils.Companion.initTestUser
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.io.IOException


@IntegrationTest
internal class UserQueryIT {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var graphQLTestTemplate: GraphQLTestTemplate

    private lateinit var userEntity: User

    @BeforeEach
    fun initTest() {
        userEntity = initTestUser(userRepository)
    }

    @Test
    @Throws(IOException::class)
    fun users() {
        userRepository.save(userEntity)

        val response = graphQLTestTemplate.postForResource("get-users.graphql")
        Assertions.assertThat(response.isOk).isTrue
        Assertions.assertThat(response["$.data.users[0].id"]).isNotNull
        Assertions.assertThat(response["$.data.users[0].username"]).isEqualTo(DEFAULT_USERNAME)
    }
}