package br.com.cristiano.reservashotel.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named("meuPrimeiroBean")
public class MeuPrimeiroBean {
    
    private String ola = "Olá do java Bean";
    private boolean mostrar = false;

    public String getOla() {
        return this.ola;
    }


    public boolean getMostrar() {
        return this.mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }    
}
