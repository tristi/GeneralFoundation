/*
 * Created on 6 Dec 2015 ( Time 04:08:59 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import tristi.general.bean.Salesordercorrection;
import tristi.general.bean.jpa.SalesordercorrectionEntity;

import java.util.Date;

import tristi.general.business.service.jpa.impl.SalesordercorrectionServiceImpl;
import tristi.general.business.service.jpa.mapping.SalesordercorrectionServiceMapper;
import tristi.general.data.repository.jpa.SalesordercorrectionJpaRepository;
import tristi.general.test.SalesordercorrectionFactoryForTest;
import tristi.general.test.SalesordercorrectionEntityFactoryForTest;
import tristi.general.test.MockValues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of SalesordercorrectionService
 */
@RunWith(MockitoJUnitRunner.class)
public class SalesordercorrectionServiceImplTest {

	@InjectMocks
	private SalesordercorrectionServiceImpl salesordercorrectionService;
	@Mock
	private SalesordercorrectionJpaRepository salesordercorrectionJpaRepository;
	@Mock
	private SalesordercorrectionServiceMapper salesordercorrectionServiceMapper;
	
	private SalesordercorrectionFactoryForTest salesordercorrectionFactoryForTest = new SalesordercorrectionFactoryForTest();

	private SalesordercorrectionEntityFactoryForTest salesordercorrectionEntityFactoryForTest = new SalesordercorrectionEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		String salesordercorrectionid = mockValues.nextString(255);
		
		SalesordercorrectionEntity salesordercorrectionEntity = salesordercorrectionJpaRepository.findOne(salesordercorrectionid);
		
		Salesordercorrection salesordercorrection = salesordercorrectionFactoryForTest.newSalesordercorrection();
		when(salesordercorrectionServiceMapper.mapSalesordercorrectionEntityToSalesordercorrection(salesordercorrectionEntity)).thenReturn(salesordercorrection);

		// When
		Salesordercorrection salesordercorrectionFound = salesordercorrectionService.findById(salesordercorrectionid);

		// Then
		assertEquals(salesordercorrection.getSalesordercorrectionid(),salesordercorrectionFound.getSalesordercorrectionid());
	}

	@Test
	public void findAll() {
		// Given
		List<SalesordercorrectionEntity> salesordercorrectionEntitys = new ArrayList<SalesordercorrectionEntity>();
		SalesordercorrectionEntity salesordercorrectionEntity1 = salesordercorrectionEntityFactoryForTest.newSalesordercorrectionEntity();
		salesordercorrectionEntitys.add(salesordercorrectionEntity1);
		SalesordercorrectionEntity salesordercorrectionEntity2 = salesordercorrectionEntityFactoryForTest.newSalesordercorrectionEntity();
		salesordercorrectionEntitys.add(salesordercorrectionEntity2);
		when(salesordercorrectionJpaRepository.findAll()).thenReturn(salesordercorrectionEntitys);
		
		Salesordercorrection salesordercorrection1 = salesordercorrectionFactoryForTest.newSalesordercorrection();
		when(salesordercorrectionServiceMapper.mapSalesordercorrectionEntityToSalesordercorrection(salesordercorrectionEntity1)).thenReturn(salesordercorrection1);
		Salesordercorrection salesordercorrection2 = salesordercorrectionFactoryForTest.newSalesordercorrection();
		when(salesordercorrectionServiceMapper.mapSalesordercorrectionEntityToSalesordercorrection(salesordercorrectionEntity2)).thenReturn(salesordercorrection2);

		// When
		List<Salesordercorrection> salesordercorrectionsFounds = salesordercorrectionService.findAll();

		// Then
		assertTrue(salesordercorrection1 == salesordercorrectionsFounds.get(0));
		assertTrue(salesordercorrection2 == salesordercorrectionsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Salesordercorrection salesordercorrection = salesordercorrectionFactoryForTest.newSalesordercorrection();

		SalesordercorrectionEntity salesordercorrectionEntity = salesordercorrectionEntityFactoryForTest.newSalesordercorrectionEntity();
		when(salesordercorrectionJpaRepository.findOne(salesordercorrection.getSalesordercorrectionid())).thenReturn(null);
		
		salesordercorrectionEntity = new SalesordercorrectionEntity();
		salesordercorrectionServiceMapper.mapSalesordercorrectionToSalesordercorrectionEntity(salesordercorrection, salesordercorrectionEntity);
		SalesordercorrectionEntity salesordercorrectionEntitySaved = salesordercorrectionJpaRepository.save(salesordercorrectionEntity);
		
		Salesordercorrection salesordercorrectionSaved = salesordercorrectionFactoryForTest.newSalesordercorrection();
		when(salesordercorrectionServiceMapper.mapSalesordercorrectionEntityToSalesordercorrection(salesordercorrectionEntitySaved)).thenReturn(salesordercorrectionSaved);

		// When
		Salesordercorrection salesordercorrectionResult = salesordercorrectionService.create(salesordercorrection);

		// Then
		assertTrue(salesordercorrectionResult == salesordercorrectionSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Salesordercorrection salesordercorrection = salesordercorrectionFactoryForTest.newSalesordercorrection();

		SalesordercorrectionEntity salesordercorrectionEntity = salesordercorrectionEntityFactoryForTest.newSalesordercorrectionEntity();
		when(salesordercorrectionJpaRepository.findOne(salesordercorrection.getSalesordercorrectionid())).thenReturn(salesordercorrectionEntity);

		// When
		Exception exception = null;
		try {
			salesordercorrectionService.create(salesordercorrection);
		} catch(Exception e) {
			exception = e;
		}

		// Then
		assertTrue(exception instanceof IllegalStateException);
		assertEquals("already.exists", exception.getMessage());
	}

	@Test
	public void update() {
		// Given
		Salesordercorrection salesordercorrection = salesordercorrectionFactoryForTest.newSalesordercorrection();

		SalesordercorrectionEntity salesordercorrectionEntity = salesordercorrectionEntityFactoryForTest.newSalesordercorrectionEntity();
		when(salesordercorrectionJpaRepository.findOne(salesordercorrection.getSalesordercorrectionid())).thenReturn(salesordercorrectionEntity);
		
		SalesordercorrectionEntity salesordercorrectionEntitySaved = salesordercorrectionEntityFactoryForTest.newSalesordercorrectionEntity();
		when(salesordercorrectionJpaRepository.save(salesordercorrectionEntity)).thenReturn(salesordercorrectionEntitySaved);
		
		Salesordercorrection salesordercorrectionSaved = salesordercorrectionFactoryForTest.newSalesordercorrection();
		when(salesordercorrectionServiceMapper.mapSalesordercorrectionEntityToSalesordercorrection(salesordercorrectionEntitySaved)).thenReturn(salesordercorrectionSaved);

		// When
		Salesordercorrection salesordercorrectionResult = salesordercorrectionService.update(salesordercorrection);

		// Then
		verify(salesordercorrectionServiceMapper).mapSalesordercorrectionToSalesordercorrectionEntity(salesordercorrection, salesordercorrectionEntity);
		assertTrue(salesordercorrectionResult == salesordercorrectionSaved);
	}

	@Test
	public void delete() {
		// Given
		String salesordercorrectionid = mockValues.nextString(255);

		// When
		salesordercorrectionService.delete(salesordercorrectionid);

		// Then
		verify(salesordercorrectionJpaRepository).delete(salesordercorrectionid);
		
	}

}