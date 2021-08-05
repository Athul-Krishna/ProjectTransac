package com.transac.OrdersService.core.events;

import com.transac.OrdersService.core.models.OrderStatus;
import lombok.Value;

@Value
public class OrderApprovedEvent {
    private final String orderId;
    private final OrderStatus orderStatus = OrderStatus.APPROVED;
}
