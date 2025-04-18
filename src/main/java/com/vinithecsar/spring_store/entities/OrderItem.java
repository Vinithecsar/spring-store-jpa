package com.vinithecsar.spring_store.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vinithecsar.spring_store.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
  private static final long serialVersionUID = 1L;

  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  @EmbeddedId
  private OrderItemPK id = new OrderItemPK();

  private Integer quantity;
  private Double price;

  public OrderItem() {
  }

  public OrderItem(Order order, Product product, Integer quantity, Double price) {
    id.setOrder(order);
    id.setProduct(product);
    this.quantity = quantity;
    this.price = price;
  }

  @JsonIgnore
  public Order getOrder() {
    return id.getOrder();
  }

  public void setOrder(Order order) {
    id.setOrder(order);
  }

  public Product getProduct() {
    return id.getProduct();
  }

  public void setProduct(Product product) {
    id.setProduct(product);
  }

  public Double getSubTotal() {
    return quantity * price;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OrderItem other = (OrderItem) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
