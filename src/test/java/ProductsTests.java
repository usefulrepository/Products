import org.example.products.PostgreSQL;
import org.example.products.Ubuntu;
import org.example.products.Windows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductsTests {

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
