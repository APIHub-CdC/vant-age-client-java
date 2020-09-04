package io.vantage.mx.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.vantage.mx.client.model.CatalogoContrato;
import io.vantage.mx.client.model.CatalogoFrecuenciaPago;
import io.vantage.mx.client.model.PersonaPeticion;

@ApiModel(description = "Datos para generar Vant/age.")
public class NoAportantesPeticion {
  @SerializedName("folio")
  private String folio = null;
  @SerializedName("fechaProceso")
  private String fechaProceso = null;
  @SerializedName("tipoContrato")
  private CatalogoContrato tipoContrato = null;
  @SerializedName("frecuenciaPago")
  private CatalogoFrecuenciaPago frecuenciaPago = null;
  @SerializedName("diasAtraso")
  private Integer diasAtraso = null;
  @SerializedName("persona")
  private PersonaPeticion persona = null;
  public NoAportantesPeticion folio(String folio) {
    this.folio = folio;
    return this;
  }
   
  @ApiModelProperty(required = true, value = "Número consecutivo único del registro")
  public String getFolio() {
    return folio;
  }
  public void setFolio(String folio) {
    this.folio = folio;
  }
  public NoAportantesPeticion fechaProceso(String fechaProceso) {
    this.fechaProceso = fechaProceso;
    return this;
  }
   
  @ApiModelProperty(required = true, value = "Fecha a la cual se requiere el proceso, pudiendo ser actual o retrospectivo (por defecto yyyy-MM-dd)")
  public String getFechaProceso() {
    return fechaProceso;
  }
  public void setFechaProceso(String fechaProceso) {
    this.fechaProceso = fechaProceso;
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
   
  @ApiModelProperty(required = true, value = "Número de días que ha estado vencido el crédito")
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
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NoAportantesPeticion noAportantesPeticion = (NoAportantesPeticion) o;
    return Objects.equals(this.folio, noAportantesPeticion.folio) &&
        Objects.equals(this.fechaProceso, noAportantesPeticion.fechaProceso) &&
        Objects.equals(this.tipoContrato, noAportantesPeticion.tipoContrato) &&
        Objects.equals(this.frecuenciaPago, noAportantesPeticion.frecuenciaPago) &&
        Objects.equals(this.diasAtraso, noAportantesPeticion.diasAtraso) &&
        Objects.equals(this.persona, noAportantesPeticion.persona);
  }
  @Override
  public int hashCode() {
    return Objects.hash(folio, fechaProceso, tipoContrato, frecuenciaPago, diasAtraso, persona);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NoAportantesPeticion {\n");
    
    sb.append("    folio: ").append(toIndentedString(folio)).append("\n");
    sb.append("    fechaProceso: ").append(toIndentedString(fechaProceso)).append("\n");
    sb.append("    tipoContrato: ").append(toIndentedString(tipoContrato)).append("\n");
    sb.append("    frecuenciaPago: ").append(toIndentedString(frecuenciaPago)).append("\n");
    sb.append("    diasAtraso: ").append(toIndentedString(diasAtraso)).append("\n");
    sb.append("    persona: ").append(toIndentedString(persona)).append("\n");
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
