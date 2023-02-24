package com.holaluz.domain

interface UserRepository {
    fun find(id: String): User?
    fun save(user: User)
}