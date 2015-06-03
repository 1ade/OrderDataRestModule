import hello.Application;
import hello.pojo.Comment;
import hello.pojo.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ifaturoti_adeyemi
 *
 */
//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@IntegrationTest
public class ProductRestServiceIntegrationTest {
	private Client client;
	private WebTarget webTarget;
	private final String baseUri = "http://localhost:8080/";
	private ObjectMapper objectMapper;
	private String json;
	private SpringApplication springApplication;
	private ApplicationContext applicationContext;
	private Product product;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		springApplication = new SpringApplication(Application.class);
		applicationContext = springApplication.run("");
		
		client = ClientBuilder.newClient();
		
		objectMapper = new ObjectMapper();
		
		product = new Product();
		product.setCode("code");
		product.setDescription("description");
		product.setName("name");
		product.setUnitPrice(new BigDecimal(222.22));
		
		Comment comment = new Comment();
		comment.setDetails("some comment");
		product.setComment(comment);
		
		json = objectMapper.writeValueAsString(product);

	}
	
	

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		client.close();	
		SpringApplication.exit(applicationContext, new ExitCodeGenerator() {
			
			@Override
			public int getExitCode() {
				return 0;
			}
		});
	}
	
	@Test
	public void testProducts() throws IOException, URISyntaxException {
		webTarget = client.target(String.format("%sproducts", baseUri));
		//save product
		doPost(webTarget, Entity.entity(json, MediaType.APPLICATION_JSON_TYPE));	
		
		
		//get all products
		String products_as_string = IOUtils.toString(getClass().getResource("/products.json"));
		doGet(webTarget, products_as_string);
		
		//get single products
		webTarget = client.target(String.format("%sproducts/1", baseUri));
		String product_as_string = IOUtils.toString(getClass().getResource("/product.json"));
		doGet(webTarget, product_as_string);
		
		//update Product
		
		json = "{\"id\":\"1\",\"unitPrice\":\"500.00\"}";
		doPatch(webTarget, Entity.entity(json, MediaType.APPLICATION_JSON_TYPE));
		
		//confirm update
		String updated_product_as_string = IOUtils.toString(getClass().getResource("/updatedProduct.json"));
		doGet(webTarget, updated_product_as_string);
		
		
		//delete product
		doDelete(webTarget);
	}
	
	private void doPost(WebTarget webTarget,Entity<? extends Object> entity){
		
		Response response = webTarget.request().post(entity);
		assert(response.getStatus()==HttpStatus.CREATED.value());
	}

	private void doGet(WebTarget webTarget, String expectedResult){
		Response response = webTarget.request().get();
		String resp = response.readEntity(String.class);
		Assert.isTrue(expectedResult.contentEquals(resp));
		assert(response.getStatus()==HttpStatus.OK.value());
	}
	
	private void doPatch(WebTarget webTarget ,Entity<? extends Object> entity){
		Response response = webTarget.request().property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true).method(HttpMethod.PATCH.name(),entity);
		assert(response.getStatus()==HttpStatus.OK.value());
	}
	
	private void doDelete(WebTarget webTarget){
		Response response = webTarget.request().delete();
		assert(response.getStatus()==HttpStatus.NO_CONTENT.value());
	}

}
