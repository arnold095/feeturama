package com.holaluz.application

import com.holaluz.domain.User
import com.holaluz.domain.UserRepository

class UserFinder {

    fun find(id: String, repository: UserRepository): User {
        return User(id, "John Doe", "aaa")
    }
}