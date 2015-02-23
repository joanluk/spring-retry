package com.emaginalabs.spring.retry;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import com.emaginalabs.spring.retry.service.ExampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-configuration/retry-config.xml"})
public class RetryAOPTest {

	private static final Logger LOG = LoggerFactory.getLogger(RetryAOPTest.class);

	@Resource
	private ExampleService service;

	@Test
	public void givenAServiceMethodWhenTryingToInvokeItThenRetry5Times() {

		try {
			
			service.sendMail();
			
			assertEquals(service.getTimes(), 4);
			
		} catch(Exception e) {
			LOG.error("Error trying to send email!");
		}

	}

}
