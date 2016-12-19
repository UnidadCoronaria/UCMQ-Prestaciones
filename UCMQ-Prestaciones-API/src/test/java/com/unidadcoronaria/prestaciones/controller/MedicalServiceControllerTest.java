package com.unidadcoronaria.prestaciones.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.unidadcoronaria.prestaciones.PrestacionesRestApplication;
import com.unidadcoronaria.prestaciones.constant.Constants;
import com.unidadcoronaria.prestaciones.service.AuthorizationService;
import com.unidadcoronaria.prestaciones.service.MedicalServiceService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PrestacionesRestApplication.class)
@WebAppConfiguration
@ActiveProfiles("scratch")
public class MedicalServiceControllerTest {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MedicalServiceResourceController medicalServiceResourceController;

	@Autowired
	private AuthorizationService authorizationService;

	@Autowired
	private MedicalServiceService medicalService;

	private MockMvc mvc;

	@Before
	public void setUp() {
		authorizationService = (AuthorizationService) context.getBean("authorizationService");
		authorizationService = Mockito.mock(AuthorizationService.class);
		ReflectionTestUtils.setField(medicalServiceResourceController, "authorizationService", authorizationService);
		medicalService = (MedicalServiceService) context.getBean("medicalService");
		medicalService = Mockito.mock(MedicalServiceService.class);
		ReflectionTestUtils.setField(medicalServiceResourceController, "medicalService", medicalService);
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testMedicalServiceList() throws Exception {
		this.mvc.perform(get("/medicalService").header(Constants.AUTHORIZATION_HEADER, "IMEI 1"))
				.andExpect(status().isOk()).andDo(print());
	}
}
