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
public class Ubuntu extends Product {

    private String osVersion;
    @Builder.Default
    private HashMap<String, String> users = new HashMap<>(Map.of("user", "12345"));;

    public void create(){
        productType = "Ubuntu";
        System.out.println("Продукт: %s успешно создан со следующими параметрами: %s,\nПользователи: %s"
                .formatted(productType, this, users));
    }

    public void addUser(String userName, String userPassword){
        users.put(userName, userPassword);
        System.out.println("Добавлен новаый пользователь: %s: %s".formatted(userName, userPassword));
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
