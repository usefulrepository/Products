import org.example.products.PostgreSQL;
import org.example.products.Ubuntu;
import org.example.products.Windows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductsTests {

    @Test
    public void postgreSQLCreateTest(){
        var postgreSQL = PostgreSQL.builder()
                .osVersion("9")
                .name("postgres-qwe")
                .build();
        postgreSQL.create();
    }

    @Test
    public void windowsCreateTest(){
        var windows = Windows.builder()
                .osVersion("11")
                .name("windows-qwe")
                .build();
        windows.create();
    }

    @Test
    public void ubuntuCreateTest(){
        var ubuntu = Ubuntu.builder()
                .osVersion("16")
                .name("ubuntu-qwe")
                .build();
        ubuntu.create();
    }
}
