package org.example.products;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
@ToString
public class Windows {

    private String productType;
    private String name;
    private String osVersion;
    @Builder.Default
    private HashMap<Character, Integer> disks = new HashMap<>(Map.of('C', 2));
    @Builder.Default
    private Boolean isOn = false;

    public void create(){
        productType = "Windows";
        System.out.println("Продукт: %s успешно создан со следующими параметрами: %s,\nДиски: %s"
                .formatted(productType, this, disks));
    }

    public void addDisk(Character diskName, Integer diskMemoryGb){
        disks.put(diskName, diskMemoryGb);
        System.out.println("Добавлен новаый диск: %s: %sgb".formatted(diskName, diskMemoryGb));
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
