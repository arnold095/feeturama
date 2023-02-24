package com.holaluz.infrastructure

import com.holaluz.domain.User
import com.holaluz.domain.UserRepository

class InMemoryUserRepository: UserRepository {
    private val users = mutableMapOf<String, User>()

    override fun find(id: String): User? {
        return users[id]
    }

    override fun save(user: User) {
        users[user.id] = user
    }
}