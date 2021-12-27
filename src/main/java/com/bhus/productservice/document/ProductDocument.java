package com.bhus.productservice.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection ="product")
public class ProductDocument {

    @Transient
    public static final String SEQUENCE_NAME = "Product";

    @Id
    private Long id;
    private String sku;
    private String name;
    private Double price;
    private String description;
    private Date dateOfManufacture;
    private Date createdDate;
}
