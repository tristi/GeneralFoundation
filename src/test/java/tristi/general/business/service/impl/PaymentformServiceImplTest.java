/*
 * Created on 6 Dec 2015 ( Time 04:08:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import tristi.general.bean.Paymentform;
import tristi.general.bean.jpa.PaymentformEntity;

import java.util.Date;
import java.util.List;

import tristi.general.business.service.jpa.impl.PaymentformServiceImpl;
import tristi.general.business.service.jpa.mapping.PaymentformServiceMapper;
import tristi.general.data.repository.jpa.PaymentformJpaRepository;
import tristi.general.test.PaymentformFactoryForTest;
import tristi.general.test.PaymentformEntityFactoryForTest;
import tristi.general.test.MockValues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of PaymentformService
 */
@RunWith(MockitoJUnitRunner.class)
public class PaymentformServiceImplTest {

	@InjectMocks
	private PaymentformServiceImpl paymentformService;
	@Mock
	private PaymentformJpaRepository paymentformJpaRepository;
	@Mock
	private PaymentformServiceMapper paymentformServiceMapper;
	
	private PaymentformFactoryForTest paymentformFactoryForTest = new PaymentformFactoryForTest();

	private PaymentformEntityFactoryForTest paymentformEntityFactoryForTest = new PaymentformEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		String paymentformid = mockValues.nextString(255);
		
		PaymentformEntity paymentformEntity = paymentformJpaRepository.findOne(paymentformid);
		
		Paymentform paymentform = paymentformFactoryForTest.newPaymentform();
		when(paymentformServiceMapper.mapPaymentformEntityToPaymentform(paymentformEntity)).thenReturn(paymentform);

		// When
		Paymentform paymentformFound = paymentformService.findById(paymentformid);

		// Then
		assertEquals(paymentform.getPaymentformid(),paymentformFound.getPaymentformid());
	}

	@Test
	public void findAll() {
		// Given
		List<PaymentformEntity> paymentformEntitys = new ArrayList<PaymentformEntity>();
		PaymentformEntity paymentformEntity1 = paymentformEntityFactoryForTest.newPaymentformEntity();
		paymentformEntitys.add(paymentformEntity1);
		PaymentformEntity paymentformEntity2 = paymentformEntityFactoryForTest.newPaymentformEntity();
		paymentformEntitys.add(paymentformEntity2);
		when(paymentformJpaRepository.findAll()).thenReturn(paymentformEntitys);
		
		Paymentform paymentform1 = paymentformFactoryForTest.newPaymentform();
		when(paymentformServiceMapper.mapPaymentformEntityToPaymentform(paymentformEntity1)).thenReturn(paymentform1);
		Paymentform paymentform2 = paymentformFactoryForTest.newPaymentform();
		when(paymentformServiceMapper.mapPaymentformEntityToPaymentform(paymentformEntity2)).thenReturn(paymentform2);

		// When
		List<Paymentform> paymentformsFounds = paymentformService.findAll();

		// Then
		assertTrue(paymentform1 == paymentformsFounds.get(0));
		assertTrue(paymentform2 == paymentformsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Paymentform paymentform = paymentformFactoryForTest.newPaymentform();

		PaymentformEntity paymentformEntity = paymentformEntityFactoryForTest.newPaymentformEntity();
		when(paymentformJpaRepository.findOne(paymentform.getPaymentformid())).thenReturn(null);
		
		paymentformEntity = new PaymentformEntity();
		paymentformServiceMapper.mapPaymentformToPaymentformEntity(paymentform, paymentformEntity);
		PaymentformEntity paymentformEntitySaved = paymentformJpaRepository.save(paymentformEntity);
		
		Paymentform paymentformSaved = paymentformFactoryForTest.newPaymentform();
		when(paymentformServiceMapper.mapPaymentformEntityToPaymentform(paymentformEntitySaved)).thenReturn(paymentformSaved);

		// When
		Paymentform paymentformResult = paymentformService.create(paymentform);

		// Then
		assertTrue(paymentformResult == paymentformSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Paymentform paymentform = paymentformFactoryForTest.newPaymentform();

		PaymentformEntity paymentformEntity = paymentformEntityFactoryForTest.newPaymentformEntity();
		when(paymentformJpaRepository.findOne(paymentform.getPaymentformid())).thenReturn(paymentformEntity);

		// When
		Exception exception = null;
		try {
			paymentformService.create(paymentform);
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
		Paymentform paymentform = paymentformFactoryForTest.newPaymentform();

		PaymentformEntity paymentformEntity = paymentformEntityFactoryForTest.newPaymentformEntity();
		when(paymentformJpaRepository.findOne(paymentform.getPaymentformid())).thenReturn(paymentformEntity);
		
		PaymentformEntity paymentformEntitySaved = paymentformEntityFactoryForTest.newPaymentformEntity();
		when(paymentformJpaRepository.save(paymentformEntity)).thenReturn(paymentformEntitySaved);
		
		Paymentform paymentformSaved = paymentformFactoryForTest.newPaymentform();
		when(paymentformServiceMapper.mapPaymentformEntityToPaymentform(paymentformEntitySaved)).thenReturn(paymentformSaved);

		// When
		Paymentform paymentformResult = paymentformService.update(paymentform);

		// Then
		verify(paymentformServiceMapper).mapPaymentformToPaymentformEntity(paymentform, paymentformEntity);
		assertTrue(paymentformResult == paymentformSaved);
	}

	@Test
	public void delete() {
		// Given
		String paymentformid = mockValues.nextString(255);

		// When
		paymentformService.delete(paymentformid);

		// Then
		verify(paymentformJpaRepository).delete(paymentformid);
		
	}

}