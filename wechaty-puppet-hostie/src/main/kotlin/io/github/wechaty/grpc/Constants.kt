package io.github.wechaty.grpc

import io.grpc.Context
import io.grpc.Metadata
import java.lang.AssertionError

class Constants private constructor() {
    companion object {
        const val BEARER_TYPE = "Wechaty"
        val AUTHORIZATION_METADATA_KEY = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER)
        val CLIENT_ID_CONTEXT_KEY = Context.key<String>("clientId")
    }

    init {
        throw AssertionError()
    }
}
