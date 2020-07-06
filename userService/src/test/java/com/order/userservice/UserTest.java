package com.order.userservice;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserAppMain.class)
public class UserTest {

	private int port = 8002;

	private URL base;

	RestTemplate restTemplate = new RestTemplate();

	@Before
	public void setUp() throws Exception {
		String url = String.format("http://localhost:%d", port);
		this.base = new URL(url);
	}

	@Test
	public void testfindUserCase1() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "1");
		String urlString = this.base.toString() + "/user/queryUserByuserId";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, getRequest(map), String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}

	@Test
	public void testfindUserCase2() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "8");
		String urlString = this.base.toString() + "/user/queryUserByuserId";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, getRequest(map), String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}
	
	@Test
	public void testQueryAddressByUserIdAndAddressIdCase1() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "1");
		map.add("addressId", "1");
		String urlString = this.base.toString() + "/user/queryAddressByAddressIdAndUserId";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, getRequest(map), String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}
	
	@Test
	public void testQueryAddressByUserIdAndAddressIdCase2() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "1");
		map.add("addressId", "2");
		String urlString = this.base.toString() + "/user/queryAddressByAddressIdAndUserId";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, getRequest(map), String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}
	
	

	private HttpEntity<MultiValueMap<String, String>> getRequest(MultiValueMap<String, String> map) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		return request;
	}

}
