package com.brunob.ordersystem.order_manager.order.domain;

import com.brunob.ordersystem.order_manager.shared.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderCode;
    private String description;
    private Double weight;
    private Double volume;
    private String recipientName;
    private String recipientPhone;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_address_id", referencedColumnName = "id")
    private OrderAddress address;

    public void cancel() {
        if (this.status == OrderStatus.DELIVERED) throw new IllegalStateException("Não é possível cancelar uma encomenda já entregue");

        this.status = OrderStatus.CANCELLED;
    }

    public void markAsDelivered() {
        if (this.status == OrderStatus.CANCELLED) throw new IllegalStateException("Não é possível entregar uma encomenda cancelada");

        this.status = OrderStatus.DELIVERED;
    }

    public boolean canBeUpdated() {
        return this.status != OrderStatus.DELIVERED && this.status != OrderStatus.CANCELLED;
    }

    public void updateStatus(OrderStatus newStatus) {
        if (!canBeUpdated()) throw new IllegalStateException("Não é possível atualizar o status de uma encomenda finalizada");

        if (this.status == OrderStatus.PENDING && newStatus == OrderStatus.DELIVERED) throw new IllegalStateException("Uma encomenda pendente não pode ir direto para entregue");

        this.status = newStatus;
    }

    public boolean isDeliverable(){
        return this.status == OrderStatus.PENDING;
    }
}
