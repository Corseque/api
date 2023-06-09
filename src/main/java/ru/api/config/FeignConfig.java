package ru.api.config;

import feign.*;
import feign.codec.ErrorDecoder;
import feign.optionals.OptionalDecoder;
import feign.slf4j.Slf4jLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.support.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.api.category.api.CategoryGateway;
import ru.api.manufacturer.api.ManufacturerGateway;
import ru.api.product.api.ProductGateway;
import ru.api.security.api.AuthenticationGateway;
import ru.api.security.api.UserGateway;

import java.util.concurrent.TimeUnit;

import static feign.FeignException.errorStatus;

@Configuration
@EnableConfigurationProperties(ApiProperties.class)
@RequiredArgsConstructor
public class FeignConfig {

    private final ObjectFactory<HttpMessageConverters> messageConverters;

    private final ObjectProvider<HttpMessageConverterCustomizer> customizers;

    private final ApiProperties apiProperties;

    @Bean
    public CategoryGateway categoryGateway() {
        return createClient(CategoryGateway.class, apiProperties.getEndPoint().getCategoryUrl());
    }

    @Bean
    public ManufacturerGateway manufacturerGateway() {
        return createClient(ManufacturerGateway.class, apiProperties.getEndPoint().getManufacturerUrl());
    }

    @Bean
    public ProductGateway productGateway() {
        return createClient(ProductGateway.class, apiProperties.getEndPoint().getProductUrl());
    }

    @Bean
    public UserGateway userGateway() {
        return createClient(UserGateway.class, apiProperties.getEndPoint().getUserUrl());
    }

    @Bean
    public AuthenticationGateway authenticationGateway() {
        return createClient(AuthenticationGateway.class, apiProperties.getEndPoint().getAuthenticationUrl());
    }

    private <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .encoder(new SpringEncoder(messageConverters))
                .decoder(new OptionalDecoder(new ResponseEntityDecoder(new SpringDecoder(this.messageConverters, this.customizers))))
                .retryer(new Retryer.Default(
                        apiProperties.getConnection().getPeriod(),
                        apiProperties.getConnection().getMaxPeriod(),
                        apiProperties.getConnection().getMaxAttempts()
                ))
                .errorDecoder(errorDecoder())
                .options(new Request.Options(
                        apiProperties.getConnection().getConnectTimeout(),
                        TimeUnit.MILLISECONDS,
//                        apiProperties.getConnection().getConnectTimeoutUnit(),
                        apiProperties.getConnection().getReadTimeout(),
                        TimeUnit.MILLISECONDS,
//                        apiProperties.getConnection().getReadTimeoutUnit(),
                        apiProperties.getConnection().isFollowRedirects()
                ))
//                .client()
                .contract(new SpringMvcContract())
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger(ManufacturerGateway.class))
                .target(type, uri);
    }

    private ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            FeignException exception = errorStatus(methodKey, response);
            if (exception.status() == 500 || exception.status() == 503) {
                return new RetryableException(
                        response.status(),
                        exception.getMessage(),
                        response.request().httpMethod(),
                        exception,
                        null,
                        response.request());
            }
            return exception;
        };
    }
}
