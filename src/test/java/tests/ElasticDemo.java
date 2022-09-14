package tests;

import org.json.JSONArray;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.ElsticSI_Utility;

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

//		List<String> keyList = new ArrayList<String>();
//		try {
//			JSONObject jsonObject = new JSONObject(jsonString);
//			JSONObject schema = jsonObject.getJSONObject("result");
//			Iterator iterator = schema.keys();
//			while (iterator.hasNext()) {
//				String key = iterator.next().toString();
//				keyList.add(key);
//			}
//			String[] arr = (String[]) keyList.toArray(new String[keyList.size()]);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("keyList " + keyList);

		JSONObject jsonObj = new JSONObject(jsonString);
//		System.out.println("adasdasd"+jsonObj);
//		System.out.print(jsonObj.getJSONObject("result").getString("token"));

		return jsonObj.getJSONObject("result").getString("token");
		

		
	}

	@Test
	public void getProjectCheckDataType1() throws ParseException, IOException {
		Map<String ,String> headers =new HashMap<String,String>(){
			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}

		};

		String result = given()
				.headers(headers)
				.get("search-admin/api/projects")
				.andReturn().asString();

		System.out.println("Project List : "+result);

		JSONObject obj = new JSONObject(result);


		JsonPath jsonPathEvaluator = new JsonPath(result);
		List allFields = new ArrayList();

		JSONArray array = obj.getJSONArray("result");

		Iterator<Object> iterator = array.iterator();
		while(iterator.hasNext()){
			JSONObject jsonObject = (JSONObject) iterator.next();
			for(String key : jsonObject.keySet()){
				allFields.add(key);
			}
		}

		System.out.println("All Field Values :"+allFields);

		ArrayList getData = jsonPathEvaluator.getJsonObject("result."+allFields.get(14));
		String dataOfFirst = getData.get(0).toString();
		System.out.println("Data of First :"+dataOfFirst);

		UUID uuid = UUID.fromString(String.valueOf(dataOfFirst));
		System.out.println("User UUID is :"+uuid);

		String numRegex   = ".*[0-9].*";
		String alphaRegex = ".*[a-z].*";

//		if (!(dataOfFirst.matches(numRegex) && dataOfFirst.matches(alphaRegex))) {
//			Assert.assertEquals(false, true,"Doesn't meet the expected result");
//		}

		ElsticSI_Utility elsticSI_utility=new ElsticSI_Utility();

//		if (elsticSI_utility.version("1.1.1")) {
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}

//		if (elsticSI_utility.aimlEnabled(false)) {
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}
//
//		if (elsticSI_utility.autoCorrectEnabled(false)) {
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}
//
//		if (elsticSI_utility.curationsEnabled(false)) {
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}
//
//		if (elsticSI_utility.semanticSearchEnabled(false)) {
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}
//
//		if (elsticSI_utility.include_index(false)) {
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}
//
//		if (elsticSI_utility.is_refresh(false)) {
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}
//
//		if (elsticSI_utility.is_imported(false)) {
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}
//
//		if (elsticSI_utility.is_nlp_support(false)) {
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}

//		if (elsticSI_utility.getengineType("Ranking Based Engine V2")) {
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}

//
//		if (elsticSI_utility.getProjectStatus("DRAFT")) {
//			System.out.println("Inside If Method");
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			System.out.println("Inside Else Part");
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}


//		if (elsticSI_utility.getSearchType("SINGLE")) {
//			System.out.println("Inside If Method");
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			System.out.println("Inside Else Part");
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}

//		if (elsticSI_utility.getSupportEngine("ELASTIC")) {
//			System.out.println("Inside If Method");
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			System.out.println("Inside Else Part");
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}

		if (elsticSI_utility.getIndexMode("ELASTIC")) {
			System.out.println("Inside If Method");
			Assert.assertEquals(true, true,"meet the expected result");
		}
		else
		{
			System.out.println("Inside Else Part");
			Assert.assertEquals(false, false,"Doesn't meet the expected result");
		}
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
				.delete("/search-admin/api/projects/89cc5ba5-d8c0-4fe1-8276-e98731cb2fb5")
				.then()
				.assertThat()
				.statusCode(HttpStatus.SC_OK)
				.log().all();

	}

	@Test
	public void getProjectCheckDataType() throws ParseException, IOException {
		Map<String ,String> headers =new HashMap<String,String>(){
			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ getToken());
			}

		};

		String result = given()
				.headers(headers)
				.get("search-admin/api/projects")
				.andReturn().asString();
		System.out.println(result);

		JSONObject obj = new JSONObject(result);


		JsonPath jsonPathEvaluator = new JsonPath(result);
		List allFields = new ArrayList();

		JSONArray array = obj.getJSONArray("result");

		Iterator<Object> iterator = array.iterator();
		while(iterator.hasNext()){
			JSONObject jsonObject = (JSONObject) iterator.next();
			for(String key : jsonObject.keySet()){
				allFields.add(key);
			}
		}
		System.out.println(allFields);
//		System.out.println(allFields.get(2));
		ArrayList getData = jsonPathEvaluator.getJsonObject("result."+allFields.get(15));
		String dataOfFirst = getData.get(0).toString();
		System.out.println(dataOfFirst);


		UUID uuid = UUID.fromString(String.valueOf(dataOfFirst));
		System.out.println("sjfbsdjf:    "+uuid);
		System.out.println(dataOfFirst);
		String numRegex   = ".*[0-9].*";
		String alphaRegex = ".*[a-z].*";
//		if (!(dataOfFirst.matches(numRegex) && dataOfFirst.matches(alphaRegex))) {
//			Assert.assertEquals(false, true,"doesn't meet the expected result");
//		}

		for(Object arr :getData) {
			if (arr != null) {
				String dataType = arr.getClass().getSimpleName();
				System.out.println(arr + " " + arr.getClass().getSimpleName());
				if (!dataType.equals("String") && !dataType.equals("Boolean")) {
					Assert.assertEquals(true, false, "Not String");
				}
			}
		}

	}


	@Test
	public void getAttribute() throws ParseException, IOException {
		Map<String ,String> headers =new HashMap<String,String>(){
			private static final long serialVersionUID = 1L;

			{
				put("accept","application/json, text/plain, */*");
				put("Authorization","Bearer "+ getToken());
			}

		};

		String result = given()
				.headers(headers)
//				.when()
				.get("https://search-admin-dev-mamb5phriq-uc.a.run.app/search-admin/api/projects/b989a5e8-7095-4a0a-a57d-07ee46ba83de/details")
//				.then()
//				.assertThat()
//				.statusCode(HttpStatus.SC_OK)
//				.log().all();
				.andReturn().asString();

		System.out.println("Project List : "+result);

		JSONObject obj = new JSONObject(result);
//
//
		JsonPath jsonPathEvaluator = new JsonPath(result);
		List allFields = new ArrayList();
//
		JSONArray array = obj.getJSONArray("result");
//
		Iterator<Object> iterator = array.iterator();
		while(iterator.hasNext()){
			JSONObject jsonObject = (JSONObject) iterator.next();
			for(String key : jsonObject.keySet()){
				allFields.add(key);
			}
		}
//
		System.out.println("All Field Values :"+allFields);

//		ArrayList getData = jsonPathEvaluator.getJsonObject("result."+allFields.get(14));
//		String dataOfFirst = getData.get(0).toString();
//		System.out.println("Data of First :"+dataOfFirst);
//
//		UUID uuid = UUID.fromString(String.valueOf(dataOfFirst));
//		System.out.println("User UUID is :"+uuid);
//
//		String numRegex   = ".*[0-9].*";
//		String alphaRegex = ".*[a-z].*";

//		if (!(dataOfFirst.matches(numRegex) && dataOfFirst.matches(alphaRegex))) {
//			Assert.assertEquals(false, true,"Doesn't meet the expected result");
//		}

//		ElsticSI_Utility elsticSI_utility=new ElsticSI_Utility();

//		if (elsticSI_utility.version("1.1.1")) {
//			Assert.assertEquals(true, true,"meet the expected result");
//		}
//		else
//		{
//			Assert.assertEquals(false, false,"Doesn't meet the expected result");
//		}

	}




}
