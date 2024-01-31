package com.example.demo.services;

import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
