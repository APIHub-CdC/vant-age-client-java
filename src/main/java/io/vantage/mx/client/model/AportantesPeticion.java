package io.vantage.mx.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Datos para generar Vant/age.")
public class AportantesPeticion {
  @SerializedName("folio")
  private String folio = null;
  @SerializedName("fechaProceso")
  private String fechaProceso = null;
  @SerializedName("numeroCuenta")
  private String numeroCuenta = null;
  @SerializedName("diasAtraso")
  private Integer diasAtraso = null;
  public AportantesPeticion folio(String folio) {
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
  public AportantesPeticion fechaProceso(String fechaProceso) {
    this.fechaProceso = fechaProceso;
    return this;
  }
   
  @ApiModelProperty(required = true, value = "Fecha a la cual se requiere el proceso, pudiendo ser actual o retrospectivo (por defecto format: yyyy-MM-dd)")
  public String getFechaProceso() {
    return fechaProceso;
  }
  public void setFechaProceso(String fechaProceso) {
    this.fechaProceso = fechaProceso;
  }
  public AportantesPeticion numeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
    return this;
  }
   
  @ApiModelProperty(required = true, value = "Número del crédito que, es asignado por el otorgante. Todas las cuentas son únicas")
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
   
  @ApiModelProperty(required = true, value = "Número de días que ha estado vencido el crédito")
  public Integer getDiasAtraso() {
    return diasAtraso;
  }
  public void setDiasAtraso(Integer diasAtraso) {
    this.diasAtraso = diasAtraso;
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
    return Objects.equals(this.folio, aportantesPeticion.folio) &&
        Objects.equals(this.fechaProceso, aportantesPeticion.fechaProceso) &&
        Objects.equals(this.numeroCuenta, aportantesPeticion.numeroCuenta) &&
        Objects.equals(this.diasAtraso, aportantesPeticion.diasAtraso);
  }
  @Override
  public int hashCode() {
    return Objects.hash(folio, fechaProceso, numeroCuenta, diasAtraso);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AportantesPeticion {\n");
    
    sb.append("    folio: ").append(toIndentedString(folio)).append("\n");
    sb.append("    fechaProceso: ").append(toIndentedString(fechaProceso)).append("\n");
    sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
    sb.append("    diasAtraso: ").append(toIndentedString(diasAtraso)).append("\n");
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
