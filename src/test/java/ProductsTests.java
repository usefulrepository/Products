import org.example.products.PostgreSQL;
import org.example.products.Product;
import org.example.products.Ubuntu;
import org.example.products.Windows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductsTests {
    //Спасибо что уделили время все ответы можете найти в этой ветке

    //todo: Дописать тест для проверки включения PostgreSQL
    /*todo: Создать тесты для проверки включения нескольких PostgreSQL:
           PostgreSQL.builder().osVersion("8").name("postgres-1").build();
           PostgreSQL.builder().osVersion("7").name("postgres-2").build();
           PostgreSQL.builder().osVersion("9").name("postgres-3").build();
     */
    /*todo: Создать тесты для проверки включения нескольких разных продуктов:
       PostgreSQL.builder().osVersion("8").name("postgres-qwe").build();
       Windows.builder().osVersion("11").name("windows-qwe").build();
       Ubuntu.builder().osVersion("16").name("ubuntu-qwe").build();
     */
    //todo: Релизовать удаление продуктов по завершению тестов в классе

    private static final List<Product> PRODUCTS_FOR_DELETE = new ArrayList<>();

    @AfterAll
    public static void deleteTestData() {
        PRODUCTS_FOR_DELETE.forEach(product -> product.delete());
    }

    public Stream<Arguments> provideArguments() {
        // Provide your custom arguments here
        return Stream.of(
                Arguments.of(PostgreSQL.builder().osVersion("8").name("postgres-qwe").build()),
                Arguments.of(Windows.builder().osVersion("11").name("windows-qwe").build()),
                Arguments.of(Ubuntu.builder().osVersion("16").name("ubuntu-qwe").build())
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void productCreateTest(Product product) {
        PRODUCTS_FOR_DELETE.add(product);
        product.create();
        product.on();
        Assertions.assertTrue(product.getIsOn(), "Продукт: %s - выключен".formatted(product.getProductType()));
    }

    @Test
    public void postgreSQLCreateTest() {
        var postgreSQL = PostgreSQL.builder()
                .osVersion("9")
                .name("postgres-qwe")
                .build();
        postgreSQL.create();
    }

    @Test
    public void windowsCreateTest() {
        var windows = Windows.builder()
                .osVersion("11")
                .name("windows-qwe")
                .build();
        windows.create();
    }

    @Test
    public void ubuntuCreateTest() {
        var ubuntu = Ubuntu.builder()
                .osVersion("16")
                .name("ubuntu-qwe")
                .build();
        ubuntu.create();
    }
}
