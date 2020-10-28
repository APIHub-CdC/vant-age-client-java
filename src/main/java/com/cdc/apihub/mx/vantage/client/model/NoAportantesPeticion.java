package com.cdc.apihub.mx.vantage.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.cdc.apihub.mx.vantage.client.model.CatalogoContrato;
import com.cdc.apihub.mx.vantage.client.model.CatalogoFrecuenciaPago;
import com.cdc.apihub.mx.vantage.client.model.CatalogoProducto;
import com.cdc.apihub.mx.vantage.client.model.PersonaPeticion;

@ApiModel(description = "Datos para generar Vant/age.")
public class NoAportantesPeticion {
	@SerializedName("folio")
	private String folio = null;
	@SerializedName("tipoProducto")
	private CatalogoProducto tipoProducto = null;
	@SerializedName("tipoContrato")
	private CatalogoContrato tipoContrato = null;
	@SerializedName("frecuenciaPago")
	private CatalogoFrecuenciaPago frecuenciaPago = null;
	@SerializedName("diasAtraso")
	private Integer diasAtraso = null;
	@SerializedName("persona")
	private PersonaPeticion persona = null;
	@SerializedName("numeroCuenta")
	private String numeroCuenta = null;
	@SerializedName("fechaApertura")
	private String fechaApertura = null;
	@SerializedName("saldoActual")
	private Float saldoActual = null;

	public NoAportantesPeticion folio(String folio) {
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

	public NoAportantesPeticion tipoProducto(CatalogoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
		return this;
	}

	@ApiModelProperty(required = true, value = "")
	public CatalogoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(CatalogoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public NoAportantesPeticion tipoContrato(CatalogoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
		return this;
	}

	@ApiModelProperty(required = true, value = "")
	public CatalogoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(CatalogoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public NoAportantesPeticion frecuenciaPago(CatalogoFrecuenciaPago frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
		return this;
	}

	@ApiModelProperty(required = true, value = "")
	public CatalogoFrecuenciaPago getFrecuenciaPago() {
		return frecuenciaPago;
	}

	public void setFrecuenciaPago(CatalogoFrecuenciaPago frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}

	public NoAportantesPeticion diasAtraso(Integer diasAtraso) {
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

	public NoAportantesPeticion persona(PersonaPeticion persona) {
		this.persona = persona;
		return this;
	}

	@ApiModelProperty(required = true, value = "")
	public PersonaPeticion getPersona() {
		return persona;
	}

	public void setPersona(PersonaPeticion persona) {
		this.persona = persona;
	}

	public NoAportantesPeticion numeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
		return this;
	}

	@ApiModelProperty(required = true, value = "No. de crédito, es asignado por el otorgante, todas las cuentas son únicas, dato para validar la relación jurídica.")
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public NoAportantesPeticion fechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
		return this;
	}

	@ApiModelProperty(required = true, value = "Fecha apertura del crédito (por defecto yyyy-MM-dd), dato para validar la relación jurídica.")
	public String getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public NoAportantesPeticion saldoActual(Float saldoActual) {
		this.saldoActual = saldoActual;
		return this;
	}

	@ApiModelProperty(required = true, value = "Saldo Actual del crédito, dato para validar la relación jurídica.")
	public Float getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(Float saldoActual) {
		this.saldoActual = saldoActual;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		NoAportantesPeticion noAportantesPeticion = (NoAportantesPeticion) o;
		return Objects.equals(this.folio, noAportantesPeticion.folio)
				&& Objects.equals(this.tipoProducto, noAportantesPeticion.tipoProducto)
				&& Objects.equals(this.tipoContrato, noAportantesPeticion.tipoContrato)
				&& Objects.equals(this.frecuenciaPago, noAportantesPeticion.frecuenciaPago)
				&& Objects.equals(this.diasAtraso, noAportantesPeticion.diasAtraso)
				&& Objects.equals(this.persona, noAportantesPeticion.persona)
				&& Objects.equals(this.numeroCuenta, noAportantesPeticion.numeroCuenta)
				&& Objects.equals(this.fechaApertura, noAportantesPeticion.fechaApertura)
				&& Objects.equals(this.saldoActual, noAportantesPeticion.saldoActual);
	}

	@Override
	public int hashCode() {
		return Objects.hash(folio, tipoProducto, tipoContrato, frecuenciaPago, diasAtraso, persona, numeroCuenta,
				fechaApertura, saldoActual);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class NoAportantesPeticion {\n");

		sb.append("    folio: ").append(toIndentedString(folio)).append("\n");
		sb.append("    tipoProducto: ").append(toIndentedString(tipoProducto)).append("\n");
		sb.append("    tipoContrato: ").append(toIndentedString(tipoContrato)).append("\n");
		sb.append("    frecuenciaPago: ").append(toIndentedString(frecuenciaPago)).append("\n");
		sb.append("    diasAtraso: ").append(toIndentedString(diasAtraso)).append("\n");
		sb.append("    persona: ").append(toIndentedString(persona)).append("\n");
		sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
		sb.append("    fechaApertura: ").append(toIndentedString(fechaApertura)).append("\n");
		sb.append("    saldoActual: ").append(toIndentedString(saldoActual)).append("\n");
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
