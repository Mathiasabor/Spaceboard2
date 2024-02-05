package com.amarerichard.database.connection

import com.amarerichard.config.config
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase

object Connection {
val client = MongoClient.create(connectionString = config.DB_URL)
    fun getDatabase() : MongoDatabase
    {
        return client.getDatabase(databaseName = config.DB_NAME)
    }
}