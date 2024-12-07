package com.fialka.service;

import com.fialka.dto.request.ProductLocationRequest;
import com.fialka.dto.response.ProductLocationResponse;

import java.util.List;
import java.util.UUID;

public interface ProductLocationService {
    ProductLocationResponse getByID(UUID id);
    ProductLocationResponse save(ProductLocationRequest productLocationRequest);
    ProductLocationResponse update(ProductLocationRequest productLocationRequest);
    ProductLocationResponse delete(ProductLocationRequest productLocationRequest);
    List<ProductLocationResponse> findAll();
    List<ProductLocationResponse> filter();
}