package com.cyfrifpro.util;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.net.ssl.TrustManagerFactory;
import java.io.InputStream;
import java.security.KeyStore;

@Component
public class SslContextProvider {

    public SslContext createSslContext() throws Exception {
        // Define the keystore type and password
        String truststorePassword = "Bbsr@2024"; // Replace with your truststore password
        String truststorePath = "keystore.p12"; // Replace with the correct truststore file name

        // Load the truststore file from the classpath
        KeyStore truststore = KeyStore.getInstance("JKS");
        try (InputStream truststoreStream = new ClassPathResource(truststorePath).getInputStream()) {
            truststore.load(truststoreStream, truststorePassword.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException("Failed to load truststore from classpath: " + truststorePath, e);
        }

        // Initialize the TrustManagerFactory with the loaded truststore
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(truststore);

        // Build the SslContext using the trust manager
        return SslContextBuilder.forClient()
                .trustManager(tmf) // Attach the trust manager
                .build();
    }
}
