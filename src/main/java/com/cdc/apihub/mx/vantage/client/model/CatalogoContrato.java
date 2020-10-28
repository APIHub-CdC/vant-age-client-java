package com.cdc.apihub.mx.vantage.client.model;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

@JsonAdapter(CatalogoContrato.Adapter.class)
public enum CatalogoContrato {

	AA("AA"),

	AB("AB"),

	AE("AE"),

	AM("AM"),

	AR("AR"),

	AV("AV"),

	BC("BC"),

	BL("BL"),

	BR("BR"),

	CA("CA"),

	CC("CC"),

	CF("CF"),

	CM("CM"),

	CO("CO"),

	CP("CP"),

	ED("ED"),

	EQ("EQ"),

	FF("FF"),

	FI("FI"),

	FT("FT"),

	GS("GS"),

	HB("HB"),

	HE("HE"),

	HV("HV"),

	LC("LC"),

	MC("MC"),

	NC("NC"),

	ND("ND"),

	NG("NG"),

	OT("OT"),

	PB("PB"),

	PC("PC"),

	PE("PE"),

	PG("PG"),

	PM("PM"),

	PN("PN"),

	PP("PP"),

	PQ("PQ"),

	SH("SH"),

	TC("TC"),

	TD("TD"),

	TG("TG"),

	TS("TS"),

	UI("UI"),

	VR("VR");
	private String value;

	CatalogoContrato(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static CatalogoContrato fromValue(String text) {
		for (CatalogoContrato b : CatalogoContrato.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	public static class Adapter extends TypeAdapter<CatalogoContrato> {
		@Override
		public void write(final JsonWriter jsonWriter, final CatalogoContrato enumeration) throws IOException {
			jsonWriter.value(enumeration.getValue());
		}

		@Override
		public CatalogoContrato read(final JsonReader jsonReader) throws IOException {
			String value = jsonReader.nextString();
			return CatalogoContrato.fromValue(String.valueOf(value));
		}
	}
}
