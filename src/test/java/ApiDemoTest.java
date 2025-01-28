import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class ApiDemoTest {

    @Test
    public void apiTest() {
        var response = RestAssured.given()
                .get("https://randomuser.me/api/")
                .jsonPath().getString("results.location.street.name");

        System.out.println(response);
    }

    @Test
    public void apiObjectTest() {
        var response = RestAssured.given()
                .get("https://randomuser.me/api/")
                .jsonPath().getObject("results[0]", UserResponse.class);

        System.out.println(response);
    }
}
