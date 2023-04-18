package ru.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "api")
public class ApiProperties {

    private Connection connection;
    private EndPoint endPoint;

    @Setter
    @Getter
    public static class EndPoint {
        private String manufacturerUrl;
        private String categoryUrl;
        private String productUrl;
        private String userUrl;
        private String authenticationUrl;
    }
    @Setter
    @Getter
    public static class Connection {
        private long period;
        private long maxPeriod;
        private int maxAttempts;
        private long connectTimeout;
//        private TimeUnit connectTimeoutUnit; todo
        private long readTimeout;
//        private TimeUnit readTimeoutUnit; todo
        private boolean followRedirects;
    }



}
