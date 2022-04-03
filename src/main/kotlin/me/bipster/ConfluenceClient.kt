package me.bipster

import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriBuilder
import jakarta.inject.Singleton
import java.net.URI
import java.util.Base64

@Singleton
class ConfluenceClient(
        @param:Client(ConfluenceConfiguration.CONFLUENCE_API_URL) private val httpClient: HttpClient,
        private val configuration: ConfluenceConfiguration) {

    fun fetchContentObjects() {
        val uri: URI = UriBuilder.of("/content")
                .queryParam("start", 4)
                .queryParam("limit", 10)
                .build()

        val encodedAuth : String = Base64.getEncoder().encodeToString(
                "${configuration.username}:${configuration.token}".toByteArray())
        val authString = "Basic $encodedAuth"

        val request : HttpRequest<*> = HttpRequest.GET<Any>(uri)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .header(HttpHeaders.AUTHORIZATION, authString)

        println(httpClient.toBlocking().retrieve(request))
    }
}