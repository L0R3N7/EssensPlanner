package me.api;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import me.models.PersonDTO;
import me.workloads.gerichte.Gericht;
import me.workloads.person.Person;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
class GerichtResourceTest {

    Headers headers = new Headers(new Header("accept", "application/json"),
            new Header("content-type", "application/json"));

    @Test
    void search() {
        List<Gericht> gerichtList = given()
                .header(new Header("accept", "application/json"))
                .when()
                .get("gericht/search/G")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList(".", Gericht.class);

        System.out.println(gerichtList.get(0).getName());
    }

    /*@Test
    void isFavorite() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setEmail("Lorenz");
        personDTO.setPassword("password");



        personDTO = given()
                .headers(this.headers)
                        .body(personDTO)
                                .when()
                                        .post("person/signin")
                                                .then()
                                                        .extract()
                                                                .as(PersonDTO.class);

        given()
                .headers(this.headers)
                .body(personDTO)
                .when()
                .post("gericht/isFavorite/1")


    }*/

    @Test
    void setFavorite() {
    }
}