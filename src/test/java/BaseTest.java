import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.http.params.CoreConnectionPNames;

public class BaseTest {

//Base constructs client and provides helper and common methods

    public RequestSpecification GetClient() {
        return GetClient(1000);
    }

    public RequestSpecification GetClient(int timeout) {

        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout)
                        .setParam(CoreConnectionPNames.SO_TIMEOUT, timeout));

        RestAssured.baseURI = "http://www.mocky.io/v2";

        return RestAssured.given().config(config);
    }

    public String ReadBodyAsString(Response response) {
        ResponseBody body = response.getBody();
        return body.asString();
    }
}
