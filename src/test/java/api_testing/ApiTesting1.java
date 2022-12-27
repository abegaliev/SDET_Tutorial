package api_testing;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiTesting1 {

    @Test
    public void checkStatus() {
	Response response = given().get("https://reqres.in/api/users?page=2");
	Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void verifySecondUser() {
	Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
		.get("https://reqres.in/api/users/2");
	Map<String, Object> responseMap = response.jsonPath().getMap("data");

	Map<String, Object> expUserMap = new HashMap<String, Object>();
	expUserMap.put("id", 2);
	expUserMap.put("email", "janet.weaver@reqres.in");
	expUserMap.put("first_name", "Janet");
	expUserMap.put("last_name", "Weaver");
	expUserMap.put("avatar", "https://reqres.in/img/faces/2-image.jpg");

	Set<String> keySet = responseMap.keySet();

	SoftAssert soft = new SoftAssert();

	for (String key : keySet) {
	    if (key != null) {
		System.out.println(responseMap.get(key));
		soft.assertEquals(responseMap.get(key), expUserMap.get(key));
	    }
	}
	soft.assertAll();
    }

    @Test
    public void verifyUserNum() {
	Response response = given().contentType(ContentType.JSON).contentType(ContentType.JSON)
		.get("https://reqres.in/api/users?pages=5");

	List<String> list = response.body().jsonPath().getList("data.first_name");
	System.out.println(list.toString());

    }

    @Test
    public void assertThat() {
	Response response = given().accept(ContentType.JSON).get("https://reqres.in/api/users?pages=3");

	response.then().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON);

    }

    @Test
    public void testWithJsonPath() {
	Response response = given().accept(ContentType.JSON).get("https://reqres.in/api/users?page=2");
	JsonPath jsonPath = response.jsonPath();

	//get all employee_id that are greater than 150
	List<Object> listOfEmpId = jsonPath.getList("data.findAll{it.id >= 10}.id");
	System.out.println("User ids over 10: " + listOfEmpId);

	List<Object> listSalary = jsonPath.getList("items.findAll{it.salary > 15000}.salary");
	System.out.println("salaries over 15000: " + listSalary);

    }


    public List<Map<String, Object>> getListMap(JsonPath json, String dataArr) {
	List<Object> list = json.getList(dataArr);
	int size = list.size();

	List<Map<String, Object>> listMap = new ArrayList<>();

	for (int i = 0; i < size; i++) {
	    listMap.add(json.getMap(dataArr + "[" + i + "]"));
	}

	return listMap;
    }

}
