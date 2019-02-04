import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class StarWarsPeopleTest extends MockyBase {

    @Test
    //Test Get retrieves list of people
    public void GetListOfPeople() {

        RequestSpecification client = GetClient();
        Response response = client.get("/5c571a434d000042100fd030");

        ResponseBody body = response.getBody();
        String bodyasString = body.asString();
        System.out.println(bodyasString);
    }

}
