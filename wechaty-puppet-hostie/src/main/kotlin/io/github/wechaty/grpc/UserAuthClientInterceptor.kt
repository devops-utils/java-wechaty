package io.github.wechaty.grpc

import io.grpc.ForwardingClientCall.SimpleForwardingClientCall
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener
import io.github.wechaty.grpc.UserAuthClientInterceptor
import io.grpc.*
import java.util.logging.Logger

class UserAuthClientInterceptor : ClientInterceptor {
    var token = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER)
    override fun <ReqT, RespT> interceptCall(
        method: MethodDescriptor<ReqT, RespT>,
        callOptions: CallOptions, next: Channel
    ): ClientCall<ReqT, RespT> {
        return object : SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            override fun start(responseListener: Listener<RespT>, headers: Metadata) {
                //此处为你登录后获得的token的值
                headers.put(token, "Wechaty token")
                super.start(object : SimpleForwardingClientCallListener<RespT>(responseListener) {
                    override fun onHeaders(headers: Metadata) {
                        /**
                         * if you don't need receive header from server, you can
                         * use [io.grpc.stub.MetadataUtils.attachHeaders]
                         * directly to send header
                         */
                        logger.info("header received from server:$headers")
                        super.onHeaders(headers)
                    }
                }, headers)
            }
        }
    }

    companion object {
        private val logger = Logger.getLogger(UserAuthClientInterceptor::class.java.name)
    }
}
