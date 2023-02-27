package com.holaluz.application

import com.holaluz.domain.User
import com.holaluz.infrastructure.InMemoryUserRepository
import org.junit.jupiter.api.Test

fun arrange(users: Array<User>): UserFinder {
    // Arrange
    val userRepository = InMemoryUserRepository()
    users.forEach { user -> userRepository.save(user) }

    return UserFinder(userRepository);
}

class UserFinderTest {
    @Test
    fun `should find a user`() {
        val id = "XXX"
        val users = arrayOf(
            User("XXX", "John Doe", "aaa@gmail.com"),
            User("ZZZ", "John Doe", "bbb@gmail.com"),
        )

        val useCase = arrange(users)

        val user = useCase.find(id)

        assert(user.id === id)
    }
}