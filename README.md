# vantage-client-java (https://img.shields.io/badge/Maven&nbsp;package-Last&nbsp;version-lemon)](https://github.com/orgs/APIHub-CdC/packages?repo_name=vantage-client-java) 
Es un modelo que segmenta a los clientes morosos en 6 calificaciones, de acuerdo al avance esperado de mora en los siguientes 30 días. Reduce costos de gestión y administración de cartera morosa al segmentar a la población.

## Requisitos

1. Java >= 1.7
2. Maven >= 3.3

## Instalación

**Prerrequisito**: obtener token de acceso y configuración de las credenciales de acceso. Consulte el manual **[aquí](https://github.com/APIHub-CdC/maven-github-packages)**.

**Opción 1**: En caso que la configuración se integró en el archivo **settingsAPIHUB.xml** (ubicado en la raíz del proyecto), instale las dependencias con siguiente comando:

```shell
mvn --settings settingsAPIHUB.xml clean install -Dmaven.test.skip=true
```

**Opción 2**: Si se integró la configuración en el **settings.xml** del **.m2**, instale las dependencias con siguiente comando:

```shell
mvn install -Dmaven.test.skip=true
```

## Guía de inicio

### Paso 1. Generar llave y certificado
Antes de lanzar la prueba se deberá tener un keystore para la llave privada y el certificado asociado a ésta.
Para generar el keystore se ejecutan las instrucciones que se encuentran en ***src/main/security/createKeystore.sh*** ó con los siguientes comandos:

**Opcional**: Si desea cifrar su contenedor, coloque una contraseña en una variable de ambiente.

```shell
export KEY_PASSWORD=your_super_secure_password
```

**Opcional**: Si desea cifrar su keystore, coloque una contraseña en una variable de ambiente.

```shell
export KEYSTORE_PASSWORD=your_super_secure_keystore_password
```

- Definición de los nombres de archivos y alias.

```shell
export PRIVATE_KEY_FILE=pri_key.pem
export CERTIFICATE_FILE=certificate.pem
export SUBJECT=/C=MX/ST=MX/L=MX/O=CDC/CN=CDC
export PKCS12_FILE=keypair.p12
export KEYSTORE_FILE=keystore.jks
export ALIAS=cdc
```
- Generar llave y certificado.

```shell
# Genera la llave privada.
openssl ecparam -name secp384r1 -genkey -out ${PRIVATE_KEY_FILE}

# Genera el certificado público
openssl req -new -x509 -days 365 \
  -key ${PRIVATE_KEY_FILE} \
  -out ${CERTIFICATE_FILE} \
  -subj "${SUBJECT}"

```

- Generar contenedor PKCS12 a partir de la llave privada y el certificado

```shell
# Genera el archivo pkcs12 a partir de la llave privada y el certificado.
# Deberá empaquetar su llave privada y el certificado.

openssl pkcs12 -name ${ALIAS} \
  -export -out ${PKCS12_FILE} \
  -inkey ${PRIVATE_KEY_FILE} \
  -in ${CERTIFICATE_FILE} \
  -password pass:${KEY_PASSWORD}

```

- Generar un keystore dummy y eliminar su contenido.

```sh
#Genera un Keystore con un par de llaves dummy.
keytool -genkey -alias dummy -keyalg RSA \
    -keysize 2048 -keystore ${KEYSTORE_FILE} \
    -dname "CN=dummy, OU=, O=, L=, S=, C=" \
    -storepass ${KEYSTORE_PASSWORD} -keypass ${KEY_PASSWORD}
#Elimina el par de llaves dummy.
keytool -delete -alias dummy \
    -keystore ${KEYSTORE_FILE} \
    -storepass ${KEYSTORE_PASSWORD}
```

- Importar el contenedor PKCS12 al keystore

```sh
#Importamos el contenedor PKCS12
keytool -importkeystore -srckeystore ${PKCS12_FILE} \
  -srcstoretype PKCS12 \
  -srcstorepass ${KEY_PASSWORD} \
  -destkeystore ${KEYSTORE_FILE} \
  -deststoretype JKS -storepass ${KEYSTORE_PASSWORD} \
  -alias ${ALIAS}
#Lista el contenido del Kesystore para verificar que
keytool -list -keystore ${KEYSTORE_FILE} \
  -storepass ${KEYSTORE_PASSWORD}
```

### Paso 2. Carga del certificado dentro del portal de desarrolladores
 1. Iniciar sesión.
 2. Dar clic en la sección "**Mis aplicaciones**".
 3. Seleccionar la aplicación.
 4. Ir a la pestaña de "**Certificados para @tuApp**".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/applications.png">
    </p>
 5. Al abrirse la ventana emergente, seleccionar el certificado previamente creado y dar clic en el botón "**Cargar**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/upload_cert.png" width="268">
    </p>
 
### Paso 3. Descarga del certificado de Círculo de Crédito dentro del portal de desarrolladores
 1. Iniciar sesión.
 2. Dar clic en la sección "**Mis aplicaciones**".
 3. Seleccionar la aplicación.
 4. Ir a la pestaña de "**Certificados para @tuApp**".
    <p align="center">
        <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/applications.png">
    </p>
 5. Al abrirse la ventana emergente, dar clic al botón "**Descargar**":
    <p align="center">
        <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/download_cert.png" width="268">
    </p>

### Paso 4. Modificar archivo de configuraciones

Para hacer uso del certificado que se descargó y el keystore que se creó se deberán modificar las rutas que se encuentran e
```properties
keystore_file=your_path_for_your_keystore/keystore.jks
cdc_cert_file=your_path_for_certificate_of_cdc/cdc_cert.pem
keystore_password=your_super_secure_keystore_password
key_alias=cdc
key_password=your_super_secure_password
```
### Paso 5. Modificar URL
En el archivo ApiTest.java, que se encuentra en ***src/test/java/com/cdc/apihub/mx/vantage/test/***. Se deberá modificar los datos de la petición y los datos de consumo:

1. Configurar ubicación y acceso de la llave creado en el **paso 1** y el certificado descargado en el **paso 2**
   - keystoreFile: ubicacion del archivo keystore.jks
   - cdcCertFile: ubicacion del archivo cdc_cert.pem
   - keystorePassword: contraseña de cifrado del keystore
   - keyAlias: alias asignado al keystore
   - keyPassword: contraseña de cifrado del contenedor

2. Credenciales de acceso dadas por Círculo de Crédito, obtenidas despues de la afiliación
   - usernameCDC: usuario de Círculo de Crédito
   - passwordCDC: contraseña de Círculo de Crédito
  
2. Datos de consumo del API
   - url: URL de la exposicón del API
   - xApiKey: Ubicada en la aplicación (creada en el **paso 2**) del portal y nombrada como Consumer Key 

> **NOTA:** Los datos de la siguiente petición son solo representativos.

```java
package com.cdc.apihub.mx.vantage.test;

...

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

```
### Paso 6. Ejecutar la prueba unitaria

Teniendo los pasos anteriores ya solo falta ejecutar la prueba unitaria, con el siguiente comando:
```shell
mvn test -Dmaven.install.skip=true
```
