import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;


public class ArtistApi extends BaseTest{

    @Test
    public void ArtistTest() {
        RequestSpecification client = GetClient(5);
        Response response = client.get("/5c2535de30000066007a62b4");

        String bodyasString = ReadBodyAsString(response);
        Assert.assertEquals(bodyasString.contains("Guernica"),true);

        System.out.print("Response body is: " + bodyasString);

    }

    @Test
    public void ArtistTest1() {
        RequestSpecification client = GetClient();
        Response response = client.get("/5c2535de30000066007a62b4?mocky-delay=2000ms");

        ResponseBody body = response.getBody();
        String bodyasString = body.asString();
        Assert.assertEquals(bodyasString.contains("Guernica"),true);

        System.out.print("Response body is: " + body.asString());

    }


    @Test
    public void validateArtistResults() {

    }
}
