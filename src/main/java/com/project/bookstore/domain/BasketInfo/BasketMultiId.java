package com.project.bookstore.domain.BasketInfo;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BasketMultiId implements Serializable {

    private Long basNum;

    private String isbn;
}
