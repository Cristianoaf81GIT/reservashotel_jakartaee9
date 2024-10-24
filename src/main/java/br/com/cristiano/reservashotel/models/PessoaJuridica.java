package br.com.cristiano.reservashotel.models;

import java.util.Objects;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa {

  private String razaoSocial;
  private String cnpj;
  private String inscricaoEstadual;
  private String inscricaoMunicipal;

  public PessoaJuridica() {
    super();
  }

  public String getRazaoSocial() {
    return this.razaoSocial;
  }

  public String getCnpj() {
    return this.cnpj;
  }

  public String getInscricaoEstadual() {
    return this.inscricaoEstadual;
  }

  public String getInscricaoMunicipal() {
    return this.inscricaoMunicipal;
  }

  public void setRazaoSocial(String valor) {
    this.razaoSocial = valor;
  }

  public void setCnpj(String valor) {
    this.cnpj = valor;
  }

  public void setInscricaoEstadual(String valor) {
    this.inscricaoEstadual = valor;
  }

  public void setInscricaoMunicipal(String valor) {
    this.inscricaoMunicipal = valor;
  }


  @Override
  public boolean equals(Object obj) {
    if (this != obj) {
      return false;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    PessoaJuridica p = (PessoaJuridica) obj;

    return cnpj == p.cnpj && Objects.equals(p.razaoSocial, razaoSocial);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cnpj, razaoSocial, inscricaoEstadual, inscricaoMunicipal);
  }
}
