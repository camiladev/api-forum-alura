package com.edu.forumAlura.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
