package ru.jms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.api.product.dto.ProductDto;
import ru.jms.config.JmsConfig;

@Component
@RequiredArgsConstructor
public class JmsListenerService {

    @JmsListener(destination = JmsConfig.JMS_PRODUCT_QUEUE)
    public ProductDto listenProductMessage(@Payload ProductDto productDto) {
        return productDto;
    }
}
