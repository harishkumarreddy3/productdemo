package com.ideyalabs.demoproject.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto2 {
    @NotNull(message = "product name can not be null")
    private String ProductName;
    @Min(100)
    private int ProductCost;
    private String ProductDescription;
    private String ProductCompany;
}
