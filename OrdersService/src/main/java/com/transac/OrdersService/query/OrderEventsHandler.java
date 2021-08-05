package com.transac.OrdersService.query;

import com.transac.OrdersService.core.data.OrderEntity;
import com.transac.OrdersService.core.data.OrdersRepository;
import com.transac.OrdersService.core.events.OrderApprovedEvent;
import com.transac.OrdersService.core.events.OrderCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

@Component
@ProcessingGroup("order-group")
public class OrderEventsHandler {

    private final OrdersRepository ordersRepository;

    public OrderEventsHandler(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @EventHandler
    public void on(OrderCreatedEvent event) {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(event, orderEntity);
        try {
            ordersRepository.save(orderEntity);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void on(OrderApprovedEvent event) {
        OrderEntity orderEntity = ordersRepository.findByOrderId(event.getOrderId());
        if(orderEntity == null) {
            // TODO: Do something about it
            return;
        }
        orderEntity.setOrderStatus(event.getOrderStatus());
        ordersRepository.save(orderEntity);
    }
}
