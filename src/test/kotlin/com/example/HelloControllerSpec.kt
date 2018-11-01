package com.example

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

object HelloControllerSpec: Spek({
    describe("hello controller tests") {
        val server = ApplicationContext.run(EmbeddedServer::class.java)
        val client = HttpClient.create(server.url)

        it("/hello returns hello world") {
            val rsp = client.toBlocking().retrieve("/hello")
            assertEquals(rsp, "hello world")
        }

        afterGroup {
            client.close()
            server.close()
        }
    }
})