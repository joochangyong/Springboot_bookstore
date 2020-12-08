package com.project.bookstore.domain.OrdersInfo;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class OrdersMultiId implements Serializable {

    private Long orderCode;

    private String isbn;
}
