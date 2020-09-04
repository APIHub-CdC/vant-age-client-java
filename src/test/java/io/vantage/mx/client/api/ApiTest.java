package io.vantage.mx.client.api;

import io.vantage.mx.client.ApiClient;
import io.vantage.mx.client.ApiException;
import io.vantage.mx.client.ApiResponse;
import io.vantage.mx.client.model.AportantesPeticion;
import io.vantage.mx.client.model.CatalogoContrato;
import io.vantage.mx.client.model.CatalogoEstados;
import io.vantage.mx.client.model.CatalogoFrecuenciaPago;
import io.vantage.mx.client.model.DomicilioPeticion;
import io.vantage.mx.client.model.NoAportantesPeticion;
import io.vantage.mx.client.model.PersonaPeticion;
import io.vantage.mx.client.model.Respuesta;
import io.vantage.mx.interceptor.SignerInterceptor;
import okhttp3.OkHttpClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Assert;
import org.junit.Before;
import java.util.concurrent.TimeUnit;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());
    private final VantAgeApi api = new VantAgeApi();
    private ApiClient apiClient = null;  
    private static final String xApiKey = "your_api_key";
    private static final String username = "your_username";
    private static final String password = "your_password";
    private static final String urlApi = "the_url";
        
    @Before()
    public void setUp() {
        this.apiClient = api.getApiClient();
        this.apiClient.setBasePath(urlApi);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new SignerInterceptor())
                .build();
        apiClient.setHttpClient(okHttpClient);
    }

    @Test
    public void getVantageAportantesTest() throws ApiException {
        
        Integer estatusOK = 200;
        Integer estatusNoContent = 204;
        AportantesPeticion peticion = new AportantesPeticion();
        try {
            
            peticion.setFolio("12345");
            peticion.setFechaProceso("2018-03-25");
            peticion.setNumeroCuenta("34232343");
            peticion.setDiasAtraso(10);
                        
            ApiResponse<?> response = api.getGenerciVantageAportantesWithHttpInfo(xApiKey, username, password, peticion);
            
            Assert.assertTrue(estatusOK.equals(response.getStatusCode()));
            
            if(estatusOK.equals(response.getStatusCode())) {
                Respuesta responseOK = (Respuesta) response.getData();
                logger.info(responseOK.toString());
            }
            
        }catch (ApiException e) {
            if(!estatusNoContent.equals(e.getCode())) {
                logger.info(e.getResponseBody());
            }
            Assert.assertTrue(estatusOK.equals(e.getCode()));
        }        
    }
    
    
    @Test
    public void getVantageNoAportantesTest() throws ApiException {
        
        Integer estatusOK = 200;
        Integer estatusNoContent = 204;
        NoAportantesPeticion peticion = new NoAportantesPeticion();
        PersonaPeticion persona = new PersonaPeticion();
        DomicilioPeticion domicilio = new DomicilioPeticion();

        try {
            
              domicilio.setDireccion("INSURGENTES SUR 1006");
              domicilio.setColoniaPoblacion("CENTRO");
              domicilio.setDelegacionMunicipio("BENITO JUAREZ");
              domicilio.setCiudad("BENITO JUAREZ");
              domicilio.setEstado(CatalogoEstados.DF);
              domicilio.setCP("04480");
              domicilio.setFechaResidencia(null);
              domicilio.setNumeroTelefono("5409098765");
              domicilio.setTipoDomicilio(null);
              domicilio.setTipoAsentamiento(null);

              persona.setApellidoPaterno("Prueba");
              persona.setApellidoMaterno("Siete");
              persona.setApellidoAdicional(null);
              persona.setPrimerNombre("Juan");
              persona.setSegundoNombre(null);
              persona.setFechaNacimiento("1980-01-07");
              persona.setRFC("PAMP010101");
              persona.setCURP(null);
              persona.setNacionalidad("MX");
              persona.setResidencia(null);
              persona.setEstadoCivil(null);
              persona.setSexo(null);
              persona.setClaveElectorIFE(null);
              persona.setNumeroDependientes(null);
              persona.setFechaDefuncion(null);
              persona.setDomicilio(domicilio);

              peticion.setFolio("12345");
              peticion.setFechaProceso("2018-03-25");
              peticion.setTipoContrato(CatalogoContrato.AA);
              peticion.setFrecuenciaPago(CatalogoFrecuenciaPago.A);
              peticion.setDiasAtraso(10);
              peticion.setPersona(persona);           
                        
            ApiResponse<?> response = api.getGenericVantageNoAportantesWithHttpInfo(xApiKey, username, password, peticion);
            
            Assert.assertTrue(estatusOK.equals(response.getStatusCode()));
            
            if(estatusOK.equals(response.getStatusCode())) {
                Respuesta responseOK = (Respuesta) response.getData();
                logger.info(responseOK.toString());
            }
            
        }catch (ApiException e) {
            if(!estatusNoContent.equals(e.getCode())) {
                logger.info(e.getResponseBody());
            }
            Assert.assertTrue(estatusOK.equals(e.getCode()));
        }         
    }
    
}
