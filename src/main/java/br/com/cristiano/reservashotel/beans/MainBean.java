package br.com.cristiano.reservashotel.beans;

import br.com.cristiano.reservashotel.services.HelloWorldService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@RequestScoped
@Named("mainBean")
public class MainBean {

    @Inject
    HelloWorldService service;

     public String getMessage() {
        return this.service.getGreetingTemplate("br", "cristiano");
    }
}

