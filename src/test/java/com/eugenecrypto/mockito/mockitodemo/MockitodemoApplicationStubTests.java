package com.eugenecrypto.mockito.mockitodemo;

import com.eugenecrypto.mockito.mockitodemo.business.DataService;
import com.eugenecrypto.mockito.mockitodemo.business.SomeBusinessImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MockitodemoApplicationStubTests {

	@Test
	void findTheGreatestFromAllData_BasicScenario() {
		DataServiceStub dataServiceStub = new DataServiceStub();
		SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
		Assertions.assertEquals(25,someBusiness.findTheGreatestFromAllData());
	}

	@Test
	void findTheGreatestFromAllData_withOneValue() {
		DataService dataServiceStub = new DataServiceStub2();
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
		int result = businessImpl.findTheGreatestFromAllData();
		Assertions.assertEquals(35, result);
	}

}

class DataServiceStub implements DataService{
	@Override
	public int[] retrieveAllData() {
		return new int[]{25,15,5};
	}

}

class DataServiceStub2 implements DataService {

	@Override
	public int[] retrieveAllData() {
		return new int[]{35};
	}

}
