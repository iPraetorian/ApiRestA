import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;


public class ArtistApi extends MockyBase {

    @Test
    //This test will allow you to set a timeout value to test whatever SLA or benchmark you want to validate
    public void ResponseTimeoutSLA() {
        RequestSpecification client = GetClient(1000);
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
}
