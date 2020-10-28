package com.cdc.apihub.mx.vantage.client.api;

import com.cdc.apihub.mx.vantage.client.ApiClient;
import com.cdc.apihub.mx.vantage.client.ApiException;
import com.cdc.apihub.mx.vantage.client.ApiResponse;
import com.cdc.apihub.mx.vantage.client.Configuration;
import com.cdc.apihub.mx.vantage.client.Pair;
import com.cdc.apihub.mx.vantage.client.ProgressRequestBody;
import com.cdc.apihub.mx.vantage.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import com.cdc.apihub.mx.vantage.client.model.AportantesPeticion;
import com.cdc.apihub.mx.vantage.client.model.NoAportantesPeticion;
import com.cdc.apihub.mx.vantage.client.model.Respuesta;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VantAgeApi {
	private ApiClient apiClient;

	public VantAgeApi() {
		this(Configuration.getDefaultApiClient());
	}

	public VantAgeApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public okhttp3.Call getVantageAportantesCall(String xApiKey, String username, String password,
			AportantesPeticion body, final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = body;
		String localVarPath = "/aportantes";
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		if (username != null)
			localVarHeaderParams.put("username", apiClient.parameterToString(username));
		if (password != null)
			localVarHeaderParams.put("password", apiClient.parameterToString(password));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call getVantageAportantesValidateBeforeCall(String xApiKey, String username, String password,
			AportantesPeticion body, final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException("Missing the required parameter 'xApiKey' when calling getVantageAportantes(Async)");
		}
		if (username == null) {
			throw new ApiException(
					"Missing the required parameter 'username' when calling getVantageAportantes(Async)");
		}
		if (password == null) {
			throw new ApiException(
					"Missing the required parameter 'password' when calling getVantageAportantes(Async)");
		}
		if (body == null) {
			throw new ApiException("Missing the required parameter 'body' when calling getVantageAportantes(Async)");
		}

		okhttp3.Call call = getVantageAportantesCall(xApiKey, username, password, body, progressListener,
				progressRequestListener);
		return call;
	}

	public Respuesta getVantageAportantes(String xSignature, String xApiKey, String username, String password,
			AportantesPeticion body) throws ApiException {
		ApiResponse<Respuesta> resp = getVantageAportantesWithHttpInfo(xApiKey, username, password, body);
		return resp.getData();
	}

	public ApiResponse<?> getGenericVantageAportantes(String xApiKey, String username, String password,
			AportantesPeticion body) throws ApiException {
		ApiResponse<?> resp = getVantageAportantesWithHttpInfo(xApiKey, username, password, body);
		return resp;
	}

	public ApiResponse<Respuesta> getVantageAportantesWithHttpInfo(String xApiKey, String username, String password,
			AportantesPeticion body) throws ApiException {
		okhttp3.Call call = getVantageAportantesValidateBeforeCall(xApiKey, username, password, body, null, null);
		Type localVarReturnType = new TypeToken<Respuesta>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	public okhttp3.Call getVantageNoAportantesCall(String xApiKey, String username, String password,
			NoAportantesPeticion body, final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = body;
		String localVarPath = "/noAportantes";
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		if (username != null)
			localVarHeaderParams.put("username", apiClient.parameterToString(username));
		if (password != null)
			localVarHeaderParams.put("password", apiClient.parameterToString(password));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call getVantageNoAportantesValidateBeforeCall(String xApiKey, String username, String password,
			NoAportantesPeticion body, final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException(
					"Missing the required parameter 'xApiKey' when calling getVantageNoAportantes(Async)");
		}
		if (username == null) {
			throw new ApiException(
					"Missing the required parameter 'username' when calling getVantageNoAportantes(Async)");
		}
		if (password == null) {
			throw new ApiException(
					"Missing the required parameter 'password' when calling getVantageNoAportantes(Async)");
		}
		if (body == null) {
			throw new ApiException("Missing the required parameter 'body' when calling getVantageNoAportantes(Async)");
		}

		okhttp3.Call call = getVantageNoAportantesCall(xApiKey, username, password, body, progressListener,
				progressRequestListener);
		return call;
	}

	public Respuesta getVantageNoAportantes(String xApiKey, String username, String password, NoAportantesPeticion body)
			throws ApiException {
		ApiResponse<Respuesta> resp = getVantageNoAportantesWithHttpInfo(xApiKey, username, password, body);
		return resp.getData();
	}

	public ApiResponse<?> getGenericVantageNoAportantes(String xApiKey, String username, String password,
			NoAportantesPeticion body) throws ApiException {
		ApiResponse<?> resp = getVantageNoAportantesWithHttpInfo(xApiKey, username, password, body);
		return resp;
	}

	public ApiResponse<Respuesta> getVantageNoAportantesWithHttpInfo(String xApiKey, String username, String password,
			NoAportantesPeticion body) throws ApiException {
		okhttp3.Call call = getVantageNoAportantesValidateBeforeCall(xApiKey, username, password, body, null, null);
		Type localVarReturnType = new TypeToken<Respuesta>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}
}
