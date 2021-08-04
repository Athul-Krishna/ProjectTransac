package com.transac.PaymentsService.query;

import com.transac.PaymentsService.core.data.PaymentEntity;
import com.transac.PaymentsService.core.data.PaymentsRepository;
import com.transac.core.events.PaymentProcessedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventsHandler {

    private final PaymentsRepository paymentsRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(PaymentEventsHandler.class);

    @Autowired
    public PaymentEventsHandler(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    @EventHandler
    public void on(PaymentProcessedEvent event) {
        LOGGER.info("PaymentProcessedEvent is called for orderId: " + event.getOrderId());
        PaymentEntity paymentEntity = new PaymentEntity();
        BeanUtils.copyProperties(event, paymentEntity);
        try {
            paymentsRepository.save(paymentEntity);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
