package com.holaluz.application

import com.holaluz.domain.User
import com.holaluz.domain.UserRepository

class UserFinder(private val repository: UserRepository) {

    fun find(id: String): User {
        return User(id, "John Doe", "aaa")
    }
}