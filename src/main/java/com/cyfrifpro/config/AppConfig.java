package com.cyfrifpro.config;

import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.cyfrifpro.util.Base64ByteArrayConverter;

import feign.Logger;

@Configuration
public class AppConfig {

	@Bean(name = "customModelMapper")
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.addConverter(Base64ByteArrayConverter.byteArrayToBase64);
		modelMapper.addConverter(Base64ByteArrayConverter.base64ToByteArray);

		modelMapper.getConfiguration().setFieldMatchingEnabled(true).setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	 @Bean
	    public RestTemplate restTemplate() throws Exception {
	        TrustManager[] trustAllCerts = new TrustManager[]{
	            new X509TrustManager() {
	                @Override
	                public void checkClientTrusted(X509Certificate[] chain, String authType) { }
	                @Override
	                public void checkServerTrusted(X509Certificate[] chain, String authType) { }
	                @Override
	                public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
	            }
	        };

	        SSLContext sslContext = SSLContext.getInstance("TLS");
	        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

	        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
	        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

	        return new RestTemplate();
	    }
}
