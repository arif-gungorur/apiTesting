import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class PostRequest extends BaseUrl{
    @Test
    public void postREquest(){
        spec.pathParam("first","todos");

        Pojo expectedData = new Pojo(20,201,"QA Tester",false);

        Response response=given().
                contentType(ContentType.JSON).
                spec(spec).
                body(expectedData).
                when().
                post("{first}");

        //response.prettyPrint();

       Pojo actualData=response.as(Pojo.class);

       assertEquals(201,response.getStatusCode());

       assertEquals(expectedData.getUserId(),actualData.getUserId());
       assertEquals(expectedData.getId(),actualData.getId());
       assertEquals(expectedData.getTitle(),actualData.getTitle());
       assertEquals(expectedData.isCompleted(),actualData.isCompleted());





    }
}
