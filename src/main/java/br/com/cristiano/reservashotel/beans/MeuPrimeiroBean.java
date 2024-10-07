package br.com.cristiano.reservashotel.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.event.AjaxBehaviorEvent;
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
    
    public void addMessage(AjaxBehaviorEvent event) {
        System.out.println("executing...");
        UIComponent component = event.getComponent();
        System.out.println("event " + component); 
        if (component instanceof UIInput) {
            System.out.println("if");
            UIInput inputComponent = (UIInput) component;
            Boolean value = (Boolean) inputComponent.getValue();
            String summary = value ? "Checked" : "Unchecked";
            this.mostrar = true;
            System.out.println(summary);
        }
    }
}
