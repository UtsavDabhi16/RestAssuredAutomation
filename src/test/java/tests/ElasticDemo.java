package tests;

import org.json.JSONException;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.given;
import java.util.*;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ElasticDemo {
	
	private String token = "";
	

	public String getToken(){
		
		RestAssured.baseURI = "https://search-admin-dev-mamb5phriq-uc.a.run.app";
		
		RequestSpecification request=RestAssured.given();
		
		String playload = "{\n"
				+ "    \"email\": \"admin@weblinktechs.com\",\n"
				+ "    \"password\": \"!adg@u^s5FE43q\"\n"
				+ "}";
		
		request.header("content-type","application/json;charset=UTF-8");
		request.header("accept","application/json, text/plain, */*");
		
		Response resFrommGenrateedToken = request.body(playload).post("/authenticate");

		String jsonString = resFrommGenrateedToken.getBody().asString();

		System.out.println("jsonString" + jsonString);

		List<String> keyList = new ArrayList<String>();
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONObject schema = jsonObject.getJSONObject("result");
			Iterator iterator = schema.keys();
			while (iterator.hasNext()) {
				String key = iterator.next().toString();
				keyList.add(key);
			}
			String[] arr = (String[]) keyList.toArray(new String[keyList.size()]);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		System.out.println("keyList " + keyList);

		JSONObject jsonObj = new JSONObject(jsonString);
		System.out.print(jsonObj.getJSONObject("result").getString("token"));
		return jsonObj.getJSONObject("result").getString("token");
		

		
	}
	
	@Test
	public void getProjects() {
		
		Map<String ,String> headers =new HashMap<String,String>(){
			
			private static final long serialVersionUID = 1L;
			
			
			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}	

		};

		given()
		.headers(headers)
		.when()
		.get("/search-admin/api/projects")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK).log().all();

		
	}


	@Test
	public void getProjectsOptimized() {
		
		Map<String ,String> headers =new HashMap<String,String>(){
			
			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}	

		};
		
		given()
		.headers(headers)
		.when()
		.get("/search-admin/api/projects/projectListing")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK).log(). all();

	}
	
	@Test
	public void getProjectsById() {
		
		Map<String ,String> headers =new HashMap<String,String>(){
			
			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}	
		};
		
		given()
		.headers(headers)
		.when()
		.get("/search-admin/api/projects/53ca594d-c13b-4367-867f-6c3af8a74c09")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK)
		.log().all();

	}
	
	
	@Test
	public void getProjectsByIdOptimized() {
		
		Map<String ,String> headers =new HashMap<String,String>(){
			
			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}	
		};
		
		given()
		.headers(headers)
		.when()
		.get("/search-admin/api/projects/53ca594d-c13b-4367-867f-6c3af8a74c09/details")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK)
		.log().all();

	}
	
	
	@Test
	public void getExtension() {
		
		Map<String ,String> headers =new HashMap<String,String>(){
			
			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}	
		};
		
		given()
		.headers(headers)
		.when()
		.get("/search-admin/api/templates/extension")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK)
		.log().all();

	}
	
	@Test
	public void getFilterDetails() {
		
		Map<String ,String> headers =new HashMap<String,String>(){
			
			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}	
		};
		
		given()
		.headers(headers)
		.when()
		.get("/search-admin/api/projects/6506c7f3-b3f0-4c78-853d-053d253e1dee/filtersDetails")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK)
		.log().all();

	}
	
	@Test
	public void getSynonymByProjectId() {
		
		Map<String ,String> headers =new HashMap<String,String>(){
			
			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}	
		};
		
		given()
		.headers(headers)
		.when()
		.get("/search-admin/api/projects/6506c7f3-b3f0-4c78-853d-053d253e1dee/filtersDetails")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK)
		.log().all();

	}


	@Test
	public void getSettingDetails() {

		Map<String ,String> headers =new HashMap<String,String>(){

			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}
		};

		given()
				.headers(headers)
				.when()
				.get("/search-admin/api/settings/settingsDetails")
				.then()
				.assertThat()
				.statusCode(HttpStatus.SC_OK)
				.log().all();

	}


	@Test
	public void createProject() {
		
	
		Map<String ,String> headers =new HashMap<String,String>(){

			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}
		};
		
		RequestSpecification request=RestAssured.given();
		
	
		String requestBody ="{\n"
				+ "    \"name\": \"Testing Demo 4\",\n"
				+ "    \"description\": \"Testing Demo\",\n"
				+ "    \"version\": \"1.1.1\",\n"
				+ "    \"is_refresh\": false,\n"
				+ "    \"search_type\": \"SINGLE\",\n"
				+ "    \"auto_correct_enabled\": false,\n"
				+ "    \"include_index\": false,\n"
				+ "    \"curations_enabled\": false,\n"
				+ "    \"semantic_search_enabled\": false,\n"
				+ "    \"index_mode\": \"ADVANCED\",\n"
				+ "    \"aiml_enabled\": false,\n"
				+ "    \"es_config_name\": \"Elastic\",\n"
				+ "    \"search_api_url\": \"https://smart-search-api-qa-mamb5phriq-uc.a.run.app\",\n"
				+ "    \"support_engine\": \"ELASTIC\",\n"
				+ "    \"schema_id\": \"3c078a58-c1e9-4629-896b-cf9bd7e328f8\",\n"
				+ "    \"schema_name\": \"best_buy_sample_aug12_3\",\n"
				+ "    \"is_nlp_support\": false,\n"
				+ "    \"engine_type\": \"Ranking Based Engine\",\n"
				+ "    \"is_schema_failed\": false,\n"
				+ "    \"is_rule_failed\": false,\n"
				+ "    \"es_config_id\": \"30c9003d-3ede-4611-a8bf-ced270b312b1\"\n"
				+ "}";
		    

		
		Response response = 
				request.contentType(ContentType.JSON).headers(headers)
                .body(requestBody)
                .post("/search-admin/api/projects");
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test
	public void updateProjectById() {

		Map<String ,String> headers =new HashMap<String,String>(){

			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}
		};

		RequestSpecification request=RestAssured.given();
		
		
		String requestBody ="{\n"
				+ "    \"name\": \"Testing Demo hello\",\n"
				+ "    \"description\": \"Testing Demo\",\n"
				+ "    \"version\": \"1.1.1\",\n"
				+ "    \"is_refresh\": false,\n"
				+ "    \"search_type\": \"SINGLE\",\n"
				+ "    \"auto_correct_enabled\": false,\n"
				+ "    \"include_index\": false,\n"
				+ "    \"curations_enabled\": false,\n"
				+ "    \"semantic_search_enabled\": false,\n"
				+ "    \"index_mode\": \"ADVANCED\",\n"
				+ "    \"aiml_enabled\": false,\n"
				+ "    \"es_config_name\": \"Elastic\",\n"
				+ "    \"search_api_url\": \"https://smart-search-api-qa-mamb5phriq-uc.a.run.app\",\n"
				+ "    \"support_engine\": \"ELASTIC\",\n"
				+ "    \"schema_id\": \"3c078a58-c1e9-4629-896b-cf9bd7e328f8\",\n"
				+ "    \"schema_name\": \"best_buy_sample_aug12_3\",\n"
				+ "    \"is_nlp_support\": false,\n"
				+ "    \"engine_type\": \"Ranking Based Engine\",\n"
				+ "    \"is_schema_failed\": false,\n"
				+ "    \"is_rule_failed\": false,\n"
				+ "    \"es_config_id\": \"30c9003d-3ede-4611-a8bf-ced270b312b1\"\n"
				+ "}";
		    
		Response response = 
				request.contentType(ContentType.JSON).headers(headers)
                .body(requestBody)
                .put("/search-admin/api/projects/84cb73fe-f6a7-4289-a285-782823443fc0");
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		

	}
	
	
	@Test
	public void deleteProjectById() {

		Map<String ,String> headers =new HashMap<String,String>(){

			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}
		};

		given()
				.headers(headers)
				.when()
				.delete("/search-admin/api/projects/84cb73fe-f6a7-4289-a285-782823443fc0")
				.then()
				.assertThat()
				.statusCode(HttpStatus.SC_OK)
				.log().all();

	}



}
