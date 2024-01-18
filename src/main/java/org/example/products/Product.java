package org.example.products;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@ToString
public abstract class Product {

    protected String productType;
    protected String name;
    protected String osVersion;
    @Builder.Default
    protected Boolean isOn = false;

    public abstract void create();

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
