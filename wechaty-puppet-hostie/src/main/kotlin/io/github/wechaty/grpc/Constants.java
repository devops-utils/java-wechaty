package io.github.wechaty.grpc;

import io.grpc.Context;
import io.grpc.Metadata;

public class Constants {
    public static final String BEARER_TYPE = "Wechaty";

    public static final Metadata.Key<String> AUTHORIZATION_METADATA_KEY = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
    public static final Context.Key<String> CLIENT_ID_CONTEXT_KEY = Context.key("clientId");

    private Constants() {
        throw new AssertionError();
    }
}
