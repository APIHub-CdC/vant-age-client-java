package io.vantage.mx.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

public class Respuesta {
  @SerializedName("folio")
  private String folio = null;
  @SerializedName("fechaProceso")
  private String fechaProceso = null;
  @SerializedName("numeroCuenta")
  private String numeroCuenta = null;
  @SerializedName("calificacion")
  private String calificacion = null;
  public Respuesta folio(String folio) {
    this.folio = folio;
    return this;
  }
   
  @ApiModelProperty(example = "13231213", value = "Número consecutivo único del registro")
  public String getFolio() {
    return folio;
  }
  public void setFolio(String folio) {
    this.folio = folio;
  }
  public Respuesta fechaProceso(String fechaProceso) {
    this.fechaProceso = fechaProceso;
    return this;
  }
   
  @ApiModelProperty(example = "2018-09-15", value = "Fecha a la cual se solicitó el proceso, pudiendo ser actual o retrospectivo")
  public String getFechaProceso() {
    return fechaProceso;
  }
  public void setFechaProceso(String fechaProceso) {
    this.fechaProceso = fechaProceso;
  }
  public Respuesta numeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
    return this;
  }
   
  @ApiModelProperty(example = "234234234", value = "Número de crédito que, es asignado por el otorgante. Todas las cuentas son únicas.")
  public String getNumeroCuenta() {
    return numeroCuenta;
  }
  public void setNumeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }
  public Respuesta calificacion(String calificacion) {
    this.calificacion = calificacion;
    return this;
  }
   
  @ApiModelProperty(example = "A", value = "Calificación de acuerdo a la probabilidad de pasar al siguiente tramo en los próximos 30 días")
  public String getCalificacion() {
    return calificacion;
  }
  public void setCalificacion(String calificacion) {
    this.calificacion = calificacion;
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
    return Objects.equals(this.folio, respuesta.folio) &&
        Objects.equals(this.fechaProceso, respuesta.fechaProceso) &&
        Objects.equals(this.numeroCuenta, respuesta.numeroCuenta) &&
        Objects.equals(this.calificacion, respuesta.calificacion);
  }
  @Override
  public int hashCode() {
    return Objects.hash(folio, fechaProceso, numeroCuenta, calificacion);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Respuesta {\n");
    
    sb.append("    folio: ").append(toIndentedString(folio)).append("\n");
    sb.append("    fechaProceso: ").append(toIndentedString(fechaProceso)).append("\n");
    sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
    sb.append("    calificacion: ").append(toIndentedString(calificacion)).append("\n");
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
