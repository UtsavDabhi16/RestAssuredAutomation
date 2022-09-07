package tests;

import org.json.JSONObject;
import org.junit.Test;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ElasticDemo {
	
	@Test
	public void getToken(){
		
		RestAssured.baseURI ="https://search-admin-dev-mamb5phriq-uc.a.run.app";
		
		RequestSpecification request=RestAssured.given();
		
		String playload = "{\n"
				+ "    \"email\": \"admin@weblinktechs.com\",\n"
				+ "    \"password\": \"!adg@u^s5FE43q\"\n"
				+ "}";
		
		request.header("content-type","application/json;charset=UTF-8");
		request.header("accept","application/json, text/plain, */*");
		
		Response resFrommGenrateedToken = request.body(playload).post("/authenticate");
		
//		resFrommGenrateedToken.prettyPrint();
		
//		System.out.println("sada"+ resFrommGenrateedToken);
		
		String jsonString = resFrommGenrateedToken.getBody().asString();
		
		System.out.println("JSON String is :"+ jsonString);
		
//		String tokenGenrated = JsonPath.from(jsonString).get("token");
		
		  JSONObject jsonObj = new JSONObject(jsonString);
		  
		  System.out.println("sdfdas"+ jsonObj);
		  String s= jsonObj.get("token").toString();
		  
//	      String name = jsonObj.getString("token");
	      System.out.println(s);
		
		
	}


}
