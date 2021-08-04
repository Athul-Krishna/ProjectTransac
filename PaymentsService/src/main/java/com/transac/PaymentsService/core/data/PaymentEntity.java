package com.transac.PaymentsService.core.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "payments")
public class PaymentEntity implements Serializable {

    private static final long serialVersionUID = 7330895400966787809L;

    @Id
    private String paymentId;

    @Column
    public String orderId;
}
