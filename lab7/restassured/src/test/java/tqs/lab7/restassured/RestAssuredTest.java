package tqs.lab7.restassured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {

    @Test
    public void verifyEndpointAvailable() {
        get("https://jsonplaceholder.typicode.com/todos").then().assertThat()
                .statusCode(200);
    }

    @Test
    public void verifyEndpointSpecificTodoReturnTitle() {
        get("https://jsonplaceholder.typicode.com/todos/4").then()
                .assertThat()
                .statusCode(200)
                .and().body("title", equalTo("et porro tempora"))
                .and().body("id", equalTo(4));
    }

    @Test
    public void verifyEndpointReturnIds() {
        get("https://jsonplaceholder.typicode.com/todos").then()
                .assertThat()
                .statusCode(200)
                .body("id", hasItems(198, 199));
    }
}
