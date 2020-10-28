package com.cdc.apihub.mx.vantage.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;
import com.cdc.apihub.mx.vantage.client.model.CatalogoExclusion;
import java.io.IOException;

public class Respuesta {
	@SerializedName("folio")
	private String folio = null;
	@SerializedName("folioConsulta")
	private String folioConsulta = null;
	@SerializedName("numeroCuenta")
	private String numeroCuenta = null;

	@JsonAdapter(CalificacionEnum.Adapter.class)
	public enum CalificacionEnum {
		A("A"),

		B("B"),

		C("C"),

		D("D"),

		E("E"),

		F("F");
		private String value;

		CalificacionEnum(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static CalificacionEnum fromValue(String text) {
			for (CalificacionEnum b : CalificacionEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}

		public static class Adapter extends TypeAdapter<CalificacionEnum> {
			@Override
			public void write(final JsonWriter jsonWriter, final CalificacionEnum enumeration) throws IOException {
				jsonWriter.value(enumeration.getValue());
			}

			@Override
			public CalificacionEnum read(final JsonReader jsonReader) throws IOException {
				String value = jsonReader.nextString();
				return CalificacionEnum.fromValue(String.valueOf(value));
			}
		}
	}

	@SerializedName("calificacion")
	private CalificacionEnum calificacion = null;
	@SerializedName("codeExclusion")
	private CatalogoExclusion codeExclusion = null;

	public Respuesta folio(String folio) {
		this.folio = folio;
		return this;
	}

	@ApiModelProperty(example = "13231213", value = "Número consecutivo único del registro, asignado por el cliente")
	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Respuesta folioConsulta(String folioConsulta) {
		this.folioConsulta = folioConsulta;
		return this;
	}

	@ApiModelProperty(example = "12244332", value = "Número consecutivo único del registro, asignado por Circulo de Crédito")
	public String getFolioConsulta() {
		return folioConsulta;
	}

	public void setFolioConsulta(String folioConsulta) {
		this.folioConsulta = folioConsulta;
	}

	public Respuesta numeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
		return this;
	}

	@ApiModelProperty(example = "234234234", value = "No. de Crédito, es asignado por el otorgante, todas las cuentas son únicas")
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Respuesta calificacion(CalificacionEnum calificacion) {
		this.calificacion = calificacion;
		return this;
	}

	@ApiModelProperty(example = "A", value = "Calificación de acuerdo a la probabilidad de pasar al siguiente tramo en los próximos 30 días")
	public CalificacionEnum getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(CalificacionEnum calificacion) {
		this.calificacion = calificacion;
	}

	public Respuesta codeExclusion(CatalogoExclusion codeExclusion) {
		this.codeExclusion = codeExclusion;
		return this;
	}

	@ApiModelProperty(value = "")
	public CatalogoExclusion getCodeExclusion() {
		return codeExclusion;
	}

	public void setCodeExclusion(CatalogoExclusion codeExclusion) {
		this.codeExclusion = codeExclusion;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Respuesta respuesta = (Respuesta) o;
		return Objects.equals(this.folio, respuesta.folio)
				&& Objects.equals(this.folioConsulta, respuesta.folioConsulta)
				&& Objects.equals(this.numeroCuenta, respuesta.numeroCuenta)
				&& Objects.equals(this.calificacion, respuesta.calificacion)
				&& Objects.equals(this.codeExclusion, respuesta.codeExclusion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(folio, folioConsulta, numeroCuenta, calificacion, codeExclusion);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Respuesta {\n");

		sb.append("    folio: ").append(toIndentedString(folio)).append("\n");
		sb.append("    folioConsulta: ").append(toIndentedString(folioConsulta)).append("\n");
		sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
		sb.append("    calificacion: ").append(toIndentedString(calificacion)).append("\n");
		sb.append("    codeExclusion: ").append(toIndentedString(codeExclusion)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
