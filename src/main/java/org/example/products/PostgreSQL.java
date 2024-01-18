package org.example.products;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
@ToString
public class PostgreSQL {

    private String productType;
    private String name;
    private String osVersion;
    @Builder.Default
    private HashMap<String, String> databases = new HashMap<>(Map.of("postgres", "12345"));
    @Builder.Default
    private Boolean isOn = false;

    public void create() {
        productType = "PostgreSQL";
        System.out.println("Продукт: %s успешно создан со следующими параметрами: %s,\nБазы данных: %s"
                .formatted(productType, this, databases));
    }

    public void addDatabase(String dbName, String dbPassword) {
        databases.put(dbName, dbPassword);
        System.out.println("Добавлена база новая данных: %s: %s".formatted(dbName, dbPassword));
    }

    public void on() {
        this.isOn = true;
        System.out.println("Продукт: %s: %s - включен".formatted(productType, name));
    }

    public void off() {
        this.isOn = false;
        System.out.println("Продукт: %s: %s - выключен".formatted(productType, name));
    }

    public void delete() {
        System.out.println("Продукт: %s: %s - успешно удален".formatted(productType, name));
    }
}
