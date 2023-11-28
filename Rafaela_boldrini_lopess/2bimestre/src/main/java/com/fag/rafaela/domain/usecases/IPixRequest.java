package com.fag.rafaela.domain.usecases;

public class IPixRequest {
  private String chavePix;
  private Double value;
  public String getChavePix() {
    return chavePix;
  }
  public void setChavePix(String chave) {
    this.chavePix = chave;
  }
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
  }
  public IPixRequest(String chave, Double value) {
    this.chavePix = chave;
    this.value = value;
  }
}
