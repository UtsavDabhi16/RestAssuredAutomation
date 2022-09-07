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
		.statusCode(HttpStatus.SC_OK).log().all();

		
	}
	
	
	@Test
	public void getProjectsOptimized() {
		
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
		.get("https://search-admin-dev-mamb5phriq-uc.a.run.app/search-admin/api/projects/projectListing")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK).log().all();

	}
	
	@Test
	public void getProjectsById() {
		
		Map<String ,String> headers =new HashMap<String,String>(){
			
			private static final long serialVersionUID = 1L;

			{
				put("Accept","*/*");
				put("Authorization","Bearer "+ "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkB3ZWJsaW5rdGVjaHMuY29tIiwiZXhwIjoxNjYyNDU0MzUzLCJpYXQiOjE2NjI0NTA3NTN9.ZS9Ozsn_kE1Kd8GaPTP3g25TaJHllKisz1U5_LydT1vNiQ8FRcDFUP_C7mcCk8ng6cQ7p349XMDpl98D2aJnKA");
			}	
		};
		
		given()
		.headers(headers)
		.when()
		.get("https://search-admin-dev-mamb5phriq-uc.a.run.app/search-admin/api/projects/53ca594d-c13b-4367-867f-6c3af8a74c09")
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
				put("Authorization","Bearer "+ "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkB3ZWJsaW5rdGVjaHMuY29tIiwiZXhwIjoxNjYyNDU4OTIwLCJpYXQiOjE2NjI0NTUzMjB9.wV3nmzpzbI4oyc1le66LTCD06apNkwQBVpj-5gUtIYLOq7YewcuwqcKMGLVhluoc3msFhQfanCGk6nzv61cK-w");
			}	
		};
		
		given()
		.headers(headers)
		.when()
		.get("https://search-admin-dev-mamb5phriq-uc.a.run.app/search-admin/api/projects/53ca594d-c13b-4367-867f-6c3af8a74c09/details")
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
				put("Authorization","Bearer "+ "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkB3ZWJsaW5rdGVjaHMuY29tIiwiZXhwIjoxNjYyNDU4OTIwLCJpYXQiOjE2NjI0NTUzMjB9.wV3nmzpzbI4oyc1le66LTCD06apNkwQBVpj-5gUtIYLOq7YewcuwqcKMGLVhluoc3msFhQfanCGk6nzv61cK-w");
			}	
		};
		
		given()
		.headers(headers)
		.when()
		.get("https://search-admin-dev-mamb5phriq-uc.a.run.app/search-admin/api/templates/extension")
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
				put("Authorization","Bearer "+ "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkB3ZWJsaW5rdGVjaHMuY29tIiwiZXhwIjoxNjYyNDU4OTIwLCJpYXQiOjE2NjI0NTUzMjB9.wV3nmzpzbI4oyc1le66LTCD06apNkwQBVpj-5gUtIYLOq7YewcuwqcKMGLVhluoc3msFhQfanCGk6nzv61cK-w");
			}	
		};
		
		given()
		.headers(headers)
		.when()
		.get("https://search-admin-dev-mamb5phriq-uc.a.run.app/search-admin/api/projects/6506c7f3-b3f0-4c78-853d-053d253e1dee/filtersDetails")
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
				put("Authorization","Bearer "+ "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkB3ZWJsaW5rdGVjaHMuY29tIiwiZXhwIjoxNjYyNDU4OTIwLCJpYXQiOjE2NjI0NTUzMjB9.wV3nmzpzbI4oyc1le66LTCD06apNkwQBVpj-5gUtIYLOq7YewcuwqcKMGLVhluoc3msFhQfanCGk6nzv61cK-w");
			}	
		};
		
		given()
		.headers(headers)
		.when()
		.get("https://search-admin-dev-mamb5phriq-uc.a.run.app/search-admin/api/projects/6506c7f3-b3f0-4c78-853d-053d253e1dee/filtersDetails")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK)
		.log().all();

	}
	
	
}
