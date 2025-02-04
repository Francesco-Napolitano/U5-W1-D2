package com.epicode.U5D1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {
    public static double COSTO_COPERTO;

    @Value("${costo.coperto:10.50}")
    public void setCostoCoperto(double costo) {
        COSTO_COPERTO = costo;
    }
}
