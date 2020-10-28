package com.cdc.apihub.mx.vantage.client.model;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

@JsonAdapter(CatalogoProducto.Adapter.class)
public enum CatalogoProducto {

	R("R"),

	F("F"),

	O("O");
	private String value;

	CatalogoProducto(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static CatalogoProducto fromValue(String text) {
		for (CatalogoProducto b : CatalogoProducto.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	public static class Adapter extends TypeAdapter<CatalogoProducto> {
		@Override
		public void write(final JsonWriter jsonWriter, final CatalogoProducto enumeration) throws IOException {
			jsonWriter.value(enumeration.getValue());
		}

		@Override
		public CatalogoProducto read(final JsonReader jsonReader) throws IOException {
			String value = jsonReader.nextString();
			return CatalogoProducto.fromValue(String.valueOf(value));
		}
	}
}
