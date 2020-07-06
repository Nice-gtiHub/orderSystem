package com.order.orderservice;

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
@SpringBootTest(classes = OrderAppMain.class)
public class OrderTest {

	private int port = 8004;

	private URL base;

	RestTemplate restTemplate = new RestTemplate();

	@Before
	public void setUp() throws Exception {
		String url = String.format("http://localhost:%d", port);
		this.base = new URL(url);
	}

	@Test
	public void testOrderCreateCase1() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "1");
		map.add("productId", "2");
		map.add("orderPrice", "22");
		map.add("payType", "wechat");
		map.add("productName", "apple");
		map.add("addressId","1");
		HttpEntity<MultiValueMap<String, String>> request = getRequest(map);
		String urlString = this.base.toString() + "/order/create";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, request, String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}

	@Test
	public void testOrderCreateCase2() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "0");
		map.add("productId", "2");
		map.add("orderPrice", "22");
		map.add("payType", "wechat");
		HttpEntity<MultiValueMap<String, String>> request = getRequest(map);
		String urlString = this.base.toString() + "/order/create?";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, request, String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}

	@Test
	public void testOrderCreateCase3() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "1");
		map.add("productId", "-1");
		map.add("orderPrice", "22");
		map.add("payType", "alipay");
		HttpEntity<MultiValueMap<String, String>> request = getRequest(map);
		String urlString = this.base.toString() + "/order/create?";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, request, String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}

	@Test
	public void testOrderCreateCase4() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "1");
		map.add("productId", "1");
		map.add("orderPrice", "-12");
		map.add("payType", "alipay");
		HttpEntity<MultiValueMap<String, String>> request = getRequest(map);
		String urlString = this.base.toString() + "/order/create?";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, request, String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}

	@Test
	public void testOrderCreateCase5() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "1");
		map.add("productId", "1");
		map.add("orderPrice", "12");
		map.add("payType", "Online banking");
		HttpEntity<MultiValueMap<String, String>> request = getRequest(map);
		String urlString = this.base.toString() + "/order/create?";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, request, String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}

	@Test
	public void testOrderCreateCase6() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "1");
		map.add("productId", "1");
		HttpEntity<MultiValueMap<String, String>> request = getRequest(map);
		String urlString = this.base.toString() + "/order/create?";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, request, String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}

	@Test
	public void testOrderCreateCase7() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "1");
		map.add("productId", "2");
		map.add("orderPrice", "22");
		map.add("payType", "wechat");
		map.add("productName", "hello");
		HttpEntity<MultiValueMap<String, String>> request = getRequest(map);
		String urlString = this.base.toString() + "/order/create";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, request, String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}

	@Test
	public void testQueryOrdersByUserIdCase1() {
		// Query the order with user 2
		System.out.println("Query the order with user 2");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "2");
		HttpEntity<MultiValueMap<String, String>> request = getRequest(map);
		String urlString = this.base.toString() + "/order/queryOrdersByUserId";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, request, String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}

	@Test
	public void testQueryOrdersByUserIdCase2() {
		// Query the order with user 1
		System.out.println("Query the order with user 2");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userId", "0");
		String urlString = this.base.toString() + "/order/queryOrdersByUserId";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, getRequest(map), String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}

	@Test
	public void testQueryOrdersByOrderNoCase1() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("outTradeNo", "20200611115158753");
		String urlString = this.base.toString() + "/order/queryOrdersByOrderNo";
		ResponseEntity<String> valueString = restTemplate.postForEntity(urlString, getRequest(map), String.class);
		System.out.println("testURL：" + urlString);
		System.out.println("test result：" + valueString.getBody().toString());
	}

	@Test
	public void testQueryOrdesrByOrderNoCase2() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("outTradeNo", "11111111s");
		String urlString = this.base.toString() + "/order/queryOrdersByOrderNo";
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
