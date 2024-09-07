package br.com.cristiano.reservashotel.services;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloWorldService {

   public String getGreetingTemplate(String language, String name) {
      String result = "Hello %s";
      switch (language) {
         case "fr" : result = "Bonjour %s"; break;
         case "de" : result = "Willkommen, %s"; break;
         case "br" : result = "Seja Bem vindo(a) %s";
      }
      return result.replace("%s", name);
   }
}
