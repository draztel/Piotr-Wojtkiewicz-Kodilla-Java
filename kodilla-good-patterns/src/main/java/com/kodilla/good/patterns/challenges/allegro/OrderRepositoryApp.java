package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDateTime;

public class OrderRepositoryApp implements OrderRepository {
    @Override
    public void addToRepository(User user, Product product, LocalDateTime dateOfOrder) {
        System.out.println("Order has been added to repository");
    }
}
