package br.com.cristiano.reservashotel.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named("meuPrimeiroBean")
public class MeuPrimeiroBean {
    
    private String ola = "Olá do java Bean";

    public String getOla() {
        return this.ola;
    }
}
