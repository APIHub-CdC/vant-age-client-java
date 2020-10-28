package com.cdc.apihub.mx.vantage.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdc.apihub.mx.vantage.client.ApiClient;
import com.cdc.apihub.mx.vantage.client.ApiException;
import com.cdc.apihub.mx.vantage.client.ApiResponse;
import com.cdc.apihub.mx.vantage.client.api.VantAgeApi;
import com.cdc.apihub.mx.vantage.client.model.AportantesPeticion;
import com.cdc.apihub.mx.vantage.client.model.CatalogoContrato;
import com.cdc.apihub.mx.vantage.client.model.CatalogoEstados;
import com.cdc.apihub.mx.vantage.client.model.CatalogoFrecuenciaPago;
import com.cdc.apihub.mx.vantage.client.model.CatalogoProducto;
import com.cdc.apihub.mx.vantage.client.model.DomicilioPeticion;
import com.cdc.apihub.mx.vantage.client.model.NoAportantesPeticion;
import com.cdc.apihub.mx.vantage.client.model.PersonaPeticion;
import com.cdc.apihub.mx.vantage.client.model.Respuesta;
import com.cdc.apihub.signer.manager.interceptor.SignerInterceptor;

import okhttp3.OkHttpClient;

public class ApiTest {

	private final VantAgeApi api = new VantAgeApi();

	private Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());

	private ApiClient apiClient;

	private String keystoreFile = "your_path_for_your_keystore/keystore.jks";
	private String cdcCertFile = "your_path_for_certificate_of_cdc/cdc_cert.pem";
	private String keystorePassword = "your_super_secure_keystore_password";
	private String keyAlias = "your_key_alias";
	private String keyPassword = "your_super_secure_password";

	private String usernameCDC = "your_username_otrorgante";
	private String passwordCDC = "your_password_otorgante";

	private String url = "the_url";
	private String xApiKey = "your_x_api_key";

	private SignerInterceptor interceptor;

	@Before()
	public void setUp() {
		interceptor = new SignerInterceptor(keystoreFile, cdcCertFile, keystorePassword, keyAlias, keyPassword);
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath(url);
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().readTimeout(30, TimeUnit.SECONDS)
				.addInterceptor(interceptor).build();
		apiClient.setHttpClient(okHttpClient);
	}

	@Test
	public void getVantageAportantesTest() throws ApiException {

		AportantesPeticion peticion = new AportantesPeticion();

		Integer estatusOK = 200;
		Integer estatusNoContent = 204;

		try {

			peticion.setFolio("0000001");
			peticion.setTipoContrato(CatalogoContrato.TC);
			peticion.setNumeroCuenta("4772133042201399");
			peticion.setDiasAtraso(1);

			ApiResponse<?> response = api.getGenericVantageAportantes(xApiKey, usernameCDC, passwordCDC, peticion);

			Assert.assertTrue(estatusOK.equals(response.getStatusCode()));

			if (estatusOK.equals(response.getStatusCode())) {
				Respuesta responseOK = (Respuesta) response.getData();
				logger.info("Vantage Aportantes Test: " + responseOK.toString());
			}

		} catch (ApiException e) {

			if (!estatusNoContent.equals(e.getCode())) {
				logger.info("getVantageAportantesTest:\n");
				logger.info("Response received from API: " + interceptor.getErrores().toString());
				logger.info("Response processed by client:" + e.getResponseBody());
			} else {

				logger.info("The response was a status 204 (NO CONTENT)");
			}

			Assert.assertTrue(estatusOK.equals(e.getCode()));
		}
	}

	@Test
	public void getVantageNoAportantesTest() throws ApiException {

		PersonaPeticion persona = new PersonaPeticion();
		DomicilioPeticion domicilio = new DomicilioPeticion();
		NoAportantesPeticion request = new NoAportantesPeticion();

		Integer estatusOK = 200;
		Integer estatusNoContent = 204;

		try {

			domicilio.setDireccion("INSURGENTES SUR 1007");
			domicilio.setColoniaPoblacion("INSURGENTES");
			domicilio.setDelegacionMunicipio("BENITO JUAREZ");
			domicilio.setCiudad("CIUDAD DE MÉXICO");
			domicilio.setEstado(CatalogoEstados.DF);
			domicilio.setCP("11230");

			persona.setPrimerNombre("PRUEBA");
			persona.setApellidoPaterno("SIETE");
			persona.setApellidoMaterno("JUAN");
			persona.setFechaNacimiento("1980-01-07");
			persona.setDomicilio(domicilio);

			request.setFolio("0000002");
			request.setTipoProducto(CatalogoProducto.O);
			request.setTipoContrato(CatalogoContrato.TC);
			request.setFrecuenciaPago(CatalogoFrecuenciaPago.M);
			request.setDiasAtraso(1);
			request.setNumeroCuenta("123456");
			request.setFechaApertura("1990-10-19");
			request.setSaldoActual(1F);
			request.setPersona(persona);

			ApiResponse<?> response = api.getGenericVantageNoAportantes(xApiKey, usernameCDC, passwordCDC, request);

			Assert.assertTrue(estatusOK.equals(response.getStatusCode()));

			if (estatusOK.equals(response.getStatusCode())) {
				Respuesta responseOK = (Respuesta) response.getData();
				logger.info("Vantage NO Aportantes Test: " + responseOK.toString());
			}

		} catch (ApiException e) {

			if (!estatusNoContent.equals(e.getCode())) {
				logger.info("getVantageNoAportantesTest:\n");
				logger.info("Response received from API: " + interceptor.getErrores().toString());
				logger.info("Response processed by client:" + e.getResponseBody());
			} else {

				logger.info("The response was a status 204 (NO CONTENT)");
			}

			Assert.assertTrue(estatusOK.equals(e.getCode()));
		}
	}

}
