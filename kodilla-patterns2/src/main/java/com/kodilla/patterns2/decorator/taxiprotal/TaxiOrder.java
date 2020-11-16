package com.kodilla.patterns2.decorator.taxiprotal;

import java.math.BigDecimal;

public interface TaxiOrder {
    BigDecimal getCost();
    String getDescription();
}
