package me.bipster

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires

@ConfigurationProperties(ConfluenceConfiguration.PREFIX)
@Requires(ConfluenceConfiguration.PREFIX)
class ConfluenceConfiguration {
    lateinit var token : String
    lateinit var username : String

    companion object {
        const val PREFIX = "confluence"
        const val CONFLUENCE_API_URL = "https://donorschoose.atlassian.net/wiki/rest/api"
    }
}