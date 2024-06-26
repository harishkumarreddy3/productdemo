package com.ideyalabs.demoproject.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int productId;
    @NotNull(message = "product name can not be null")
    @NotEmpty
    private String ProductName;
    @Min(100)
    private int ProductCost;
    private String ProductDescription;
    private String ProductCompany;
}
