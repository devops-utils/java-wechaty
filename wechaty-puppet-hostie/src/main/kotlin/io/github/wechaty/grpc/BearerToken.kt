package io.github.wechaty.grpc

import io.grpc.CallCredentials
import io.grpc.Metadata
import io.grpc.Status
import java.lang.Runnable
import java.util.concurrent.Executor

class BearerToken(private val value: String?) : CallCredentials() {
    override fun applyRequestMetadata(requestInfo: RequestInfo, executor: Executor, metadataApplier: MetadataApplier) {
        executor.execute {
            try {
                val headers = Metadata()
                headers.put(Constants.AUTHORIZATION_METADATA_KEY, String.format("%s %s", Constants.BEARER_TYPE, value))
                metadataApplier.apply(headers)
            } catch (e: Throwable) {
                metadataApplier.fail(Status.UNAUTHENTICATED.withCause(e))
            }
        }
    }

    override fun thisUsesUnstableApi() {
        // noop
    }
}
