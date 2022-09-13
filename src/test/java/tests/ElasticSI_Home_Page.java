package tests;

import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ElasticSI_Home_Page {

	
private String token = "";

	@Test
	public void email_and_passwordIsEmpty(){

		RestAssured.baseURI ="https://search-admin-dev-mamb5phriq-uc.a.run.app";

		RequestSpecification request=RestAssured.given();

		String playload = "{\n" +
				"    \"email\": \"\",\n" +
				"    \"password\": \"\"\n" +
				"}";

		request.header("content-type","application/json;charset=UTF-8");
		request.header("accept","application/json, text/plain, */*");

		Response resFrommGenrateedToken = request.body(playload).post("/authenticate");

		System.out.println("Response Value "+resFrommGenrateedToken.getStatusCode());

		Assert.assertEquals(resFrommGenrateedToken.getStatusCode(),200,"Email and Password ");

	}

	@Test
	public void passwordIsEmpty(){
		
		RestAssured.baseURI ="https://search-admin-dev-mamb5phriq-uc.a.run.app";
		
		RequestSpecification request=RestAssured.given();
		
		String playload = "{\n" +
				"    \"email\": \"admin@weblinktechs.com\",\n" +
				"    \"password\": \"\"\n" +
				"}";
		request.header("content-type","application/json;charset=UTF-8");
		request.header("accept","application/json, text/plain, */*");
		
		Response resFrommGenrateedToken = request.body(playload).post("/authenticate");
		
		System.out.println("Response Value "+resFrommGenrateedToken.getStatusCode());
		
		Assert.assertEquals(resFrommGenrateedToken.getStatusCode(),200);

	}

	@Test
	public void emailIsEmpty(){

		RestAssured.baseURI ="https://search-admin-dev-mamb5phriq-uc.a.run.app";

		RequestSpecification request=RestAssured.given();

		String playload = "{\n" +
				"    \"email\": \"\",\n" +
				"    \"password\": \"!adg@u^s5FE43q\"\n" +
				"}";
		request.header("content-type","application/json;charset=UTF-8");
		request.header("accept","application/json, text/plain, */*");

		Response resFrommGenrateedToken = request.body(playload).post("/authenticate");

		System.out.println("Response Value "+resFrommGenrateedToken.getStatusCode());

		Assert.assertEquals(resFrommGenrateedToken.getStatusCode(),200);

	}


	@Test
	public void emailandPasswordValid(){

		RestAssured.baseURI ="https://search-admin-dev-mamb5phriq-uc.a.run.app";

		RequestSpecification request=RestAssured.given();

		String playload = "{\n" +
				"    \"email\": \"admin@weblinktechs.com\",\n" +
				"    \"password\": \"!adg@u^s5FE43q\"\n" +
				"}";
		request.header("content-type","application/json;charset=UTF-8");
		request.header("accept","application/json, text/plain, */*");

		Response resFrommGenrateedToken = request.body(playload).post("/authenticate");

		System.out.println("Response Value "+resFrommGenrateedToken.getStatusCode());

		Assert.assertEquals(resFrommGenrateedToken.getStatusCode(),200);

	}

	@Test
	public void emailandInvalidPassword(){

		RestAssured.baseURI ="https://search-admin-dev-mamb5phriq-uc.a.run.app";

		RequestSpecification request=RestAssured.given();

		String playload = "{\n" +
				"    \"email\": \"admin@weblinktechs.com\",\n" +
				"    \"password\": \"!adg@u^sutsav\"\n" +
				"}";
		request.header("content-type","application/json;charset=UTF-8");
		request.header("accept","application/json, text/plain, */*");

		Response resFrommGenrateedToken = request.body(playload).post("/authenticate");

		System.out.println("Response Value "+resFrommGenrateedToken.getStatusCode());

		Assert.assertEquals(resFrommGenrateedToken.getStatusCode(),200);

	}

	@Test
	public void inValidEmailandvalidPassword(){

		RestAssured.baseURI ="https://search-admin-dev-mamb5phriq-uc.a.run.app";

		RequestSpecification request=RestAssured.given();

		String playload = "{\n" +
				"    \"email\": \"admin@weblinktechs.in\",\n" +
				"    \"password\": \"!adg@u^s5FE43q\"\n" +
				"}";
		request.header("content-type","application/json;charset=UTF-8");
		request.header("accept","application/json, text/plain, */*");

		Response resFrommGenrateedToken = request.body(playload).post("/authenticate");

		System.out.println("Response Value "+resFrommGenrateedToken.getStatusCode());

		Assert.assertEquals(resFrommGenrateedToken.getStatusCode(),200);

	}

	@Test
	public void inValidEmailandInvalidPassword(){

		RestAssured.baseURI ="https://search-admin-dev-mamb5phriq-uc.a.run.app";

		RequestSpecification request=RestAssured.given();

		String playload = "{\n" +
				"    \"email\": \"admin@weblinktechs.in\",\n" +
				"    \"password\": \"!adg@u^sdfsFE43q\"\n" +
				"}";
		request.header("content-type","application/json;charset=UTF-8");
		request.header("accept","application/json, text/plain, */*");

		Response resFrommGenrateedToken = request.body(playload).post("/authenticate");

		System.out.println("Response Value "+resFrommGenrateedToken.getStatusCode());

		Assert.assertEquals(resFrommGenrateedToken.getStatusCode(),200);

	}

}
