package com.communitygaming.tournamentproject.graphql.resolver.mutation

import com.graphql.spring.boot.test.GraphQLTestTemplate
import com.communitygaming.tournamentproject.IntegrationTest
import com.communitygaming.tournamentproject.utils.UserUtils.Companion.DEFAULT_USERNAME
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.io.IOException


@IntegrationTest
internal class UserMutationIT {

    @Autowired
    private lateinit var graphQLTestTemplate: GraphQLTestTemplate

    @Test
    @Throws(IOException::class)
    fun createUser() {
        val response = graphQLTestTemplate.postForResource("new-user.graphql")
        Assertions.assertThat(response.isOk).isTrue
        Assertions.assertThat(response["$.data.newUser.id"]).isNotNull
        Assertions.assertThat(response["$.data.newUser.username"]).isEqualTo(DEFAULT_USERNAME)
    }
}