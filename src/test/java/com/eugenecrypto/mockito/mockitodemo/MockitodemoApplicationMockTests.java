package com.eugenecrypto.mockito.mockitodemo;

import com.eugenecrypto.mockito.mockitodemo.business.DataService;
import com.eugenecrypto.mockito.mockitodemo.business.SomeBusinessImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MockitodemoApplicationMockTests {


	@Mock
	private DataService dataServiceMock;

	@InjectMocks
	SomeBusinessImpl someBusiness;


	@Test
	void findTheGreatestFromAllData_BasicScenario() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25,15,5});
		int testResult = someBusiness.findTheGreatestFromAllData();
		assertEquals(25,testResult);
	}

	@Test
	void findTheGreatestFromAllData_withOneValueScenario() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
		assertEquals(35,someBusiness.findTheGreatestFromAllData());
	}
}


