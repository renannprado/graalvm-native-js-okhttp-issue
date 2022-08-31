package dev.renann.issue;

import okhttp3.OkHttpClient;
import org.graalvm.polyglot.Context;
public class Main {

    public static void main(String... args) {

        System.out.println("starting application");

        try (final var context = Context.newBuilder()
                .allowAllAccess(true)
                .build()) {
            final var js = context.getBindings("js");
            js.putMember("httpClient", new OkHttpClient());
            context.eval("js", """
                            const Request = Java.type("okhttp3.Request");
                            console.log(Request.Builder);
                            const req = new Request.Builder()
                                            .url("https://www.example.com")
                                            .build();
                                        
                            httpClient.newCall(req).execute();
                    """);
        }
    }
}
