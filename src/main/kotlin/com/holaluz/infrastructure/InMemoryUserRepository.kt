package com.holaluz.infrastructure

import com.holaluz.domain.User
import com.holaluz.domain.UserRepository

class InMemoryUserRepository: UserRepository {
    private val users = mutableMapOf<String, User>()

    override fun find(id: String): User? {
        if (users[id] !== null) {
            return users[id]
        } else {
            return User(id, "John Doe", "aaa@gmail.com")
        }
    }

    override fun save(user: User) {
        users[user.id] = user
    }
}