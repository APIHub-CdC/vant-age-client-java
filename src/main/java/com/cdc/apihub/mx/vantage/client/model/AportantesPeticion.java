package com.cdc.apihub.mx.vantage.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.cdc.apihub.mx.vantage.client.model.CatalogoContrato;

@ApiModel(description = "Datos para generar Vant/age.")

public class AportantesPeticion {
	@SerializedName("folio")
	private String folio = null;
	@SerializedName("numeroCuenta")
	private String numeroCuenta = null;
	@SerializedName("diasAtraso")
	private Integer diasAtraso = null;
	@SerializedName("tipoContrato")
	private CatalogoContrato tipoContrato = null;

	public AportantesPeticion folio(String folio) {
		this.folio = folio;
		return this;
	}

	@ApiModelProperty(required = true, value = "Número consecutivo único del registro, asignado por el cliente")
	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public AportantesPeticion numeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
		return this;
	}

	@ApiModelProperty(required = true, value = "No. del crédito, es asignado por el otorgante, todas las cuentas son únicas")
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public AportantesPeticion diasAtraso(Integer diasAtraso) {
		this.diasAtraso = diasAtraso;
		return this;
	}

	@ApiModelProperty(required = true, value = "No. de días que ha estado vencido el crédito")
	public Integer getDiasAtraso() {
		return diasAtraso;
	}

	public void setDiasAtraso(Integer diasAtraso) {
		this.diasAtraso = diasAtraso;
	}

	public AportantesPeticion tipoContrato(CatalogoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
		return this;
	}

	@ApiModelProperty(value = "")
	public CatalogoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(CatalogoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AportantesPeticion aportantesPeticion = (AportantesPeticion) o;
		return Objects.equals(this.folio, aportantesPeticion.folio)
				&& Objects.equals(this.numeroCuenta, aportantesPeticion.numeroCuenta)
				&& Objects.equals(this.diasAtraso, aportantesPeticion.diasAtraso)
				&& Objects.equals(this.tipoContrato, aportantesPeticion.tipoContrato);
	}

	@Override
	public int hashCode() {
		return Objects.hash(folio, numeroCuenta, diasAtraso, tipoContrato);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AportantesPeticion {\n");

		sb.append("    folio: ").append(toIndentedString(folio)).append("\n");
		sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
		sb.append("    diasAtraso: ").append(toIndentedString(diasAtraso)).append("\n");
		sb.append("    tipoContrato: ").append(toIndentedString(tipoContrato)).append("\n");
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
