package tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class ElasticSI_Project {
	

	@Test
	public void getProjects() {
		
		Map<String ,String> headers =new HashMap<String,String>(){
			
			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkB3ZWJsaW5rdGVjaHMuY29tIiwiZXhwIjoxNjYyNDUwNDg0LCJpYXQiOjE2NjI0NDY4ODR9.XIGLA5FdmrTXgrHwVvXnH8mMhPl8Ssnq5pHrksAahmt4q-aeM8RGMK9RdPCN_LQKoa9kd00lSJSdpkLFUVfCqA");
			}	

		};
		
		given()
		.headers(headers)
		.when()
		.get("https://search-admin-dev-mamb5phriq-uc.a.run.app/search-admin/api/projects")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK);
		
	}
}
