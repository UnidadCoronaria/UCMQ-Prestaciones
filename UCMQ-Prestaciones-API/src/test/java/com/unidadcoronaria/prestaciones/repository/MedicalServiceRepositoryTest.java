package com.unidadcoronaria.prestaciones.repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.unidadcoronaria.prestaciones.PrestacionesRestApplication;
import com.unidadcoronaria.prestaciones.domain.MedicalService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PrestacionesRestApplication.class)
@WebAppConfiguration
@ActiveProfiles("scratch")
public class MedicalServiceRepositoryTest {

	private static Log logger = LogFactory.getLog(MedicalServiceRepositoryTest.class);

	@Autowired
	private MedicalServiceRepository repository;

	@Test
	public void testMedicalServiceRepository() throws Exception {
		repository.save(new MedicalService(1l));
		repository.save(new MedicalService(2l));
		repository.save(new MedicalService(3l));

		logger.info("MedicalService found with findAll():");
		logger.info("-------------------------------");
		for (MedicalService customer : repository.findAll()) {
			logger.info(customer.toString());
		}
		logger.info("");

		MedicalService medicalService = repository.findOne(1L);
		logger.info("MedicalService found with findOne(1L):");
		logger.info("--------------------------------");
		logger.info(medicalService.toString());
		logger.info("");

		logger.info("MedicalService found with findByLastName('Bauer'):");
		logger.info("--------------------------------------------");
		MedicalService medicalService2 = repository.findById(2l);
		logger.info(medicalService2.toString());
		logger.info("");
	}
}
