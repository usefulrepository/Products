package org.example.products;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.Map;

@SuperBuilder
@Getter
@ToString(callSuper = true)
public class PostgreSQL extends Product {

    @Builder.Default
    private HashMap<String, String> databases = new HashMap<>(Map.of("postgres", "12345"));

    @Override
    public void create() {
        productType = "PostgresSql";
        System.out.println("Продукт: %s успешно создан со следующими параметрами: %s,\nБазы данных: %s"
                .formatted(productType, this, databases));
    }

    public void addDatabase(String dbName, String dbPassword) {
        databases.put(dbName, dbPassword);
        System.out.println("Добавлена база новая данных: %s: %s".formatted(dbName, dbPassword));
    }
}
