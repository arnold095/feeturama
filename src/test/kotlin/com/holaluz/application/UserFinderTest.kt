package com.holaluz.application

import com.holaluz.infrastructure.InMemoryUserRepository
import org.junit.jupiter.api.Test

fun arrange(): UserFinder {
    // Arrange

    return UserFinder()
}

class UserFinderTest {
    @Test
    fun `should find a user`() {
        val id = "XXX"

        val useCase = arrange()

        val user = useCase.find(id, InMemoryUserRepository())

        assert(user.id == id)
    }
}