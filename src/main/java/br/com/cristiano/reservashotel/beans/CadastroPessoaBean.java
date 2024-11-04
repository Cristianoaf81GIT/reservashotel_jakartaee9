package br.com.cristiano.reservashotel.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import br.com.cristiano.reservashotel.enums.Sexo;
import br.com.cristiano.reservashotel.models.Pessoa;
import br.com.cristiano.reservashotel.models.PessoaFisica;
import br.com.cristiano.reservashotel.models.PessoaJuridica;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("cadastroPessoaBean")
@SessionScoped
public class CadastroPessoaBean implements Serializable {

  private static final long serialVersionUID = -7600674761430266600L;

  private Pessoa pessoaSelecionada;
  private List<Pessoa> lista;
  private String tipoNovaPessoa;

  public CadastroPessoaBean() {
    // this.pessoaSelecionada = new PessoaFisica();
    this.lista = new ArrayList<Pessoa>();
    for (int x = 0; x < 10; x++) {
      Pessoa p = (x % 2 == 0) ? new PessoaFisica() : new PessoaJuridica();
      p.setNome(String.format("fulano %02d", x));
      p.setEmail(String.format("fulano%02d@email.com", x));
      p.setTelefone(String.format("999.88%2d", x));
      p.setCodigo(x);
      this.lista.add(p);
    }
  }

  public void criar() {
    FacesContext context = FacesContext.getCurrentInstance();
    if (tipoNovaPessoa == null) {
      context.addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_WARN,
          "Você precisa especificar o tipo da pessoa!", ""));
      return;
    }

    System.out.println("tipo de pessoa " + tipoNovaPessoa);

    if (tipoNovaPessoa.equals("PF")) {
      pessoaSelecionada = new PessoaFisica();
    } else if (tipoNovaPessoa.equals("PJ")) {
      pessoaSelecionada = new PessoaJuridica();
    }
    context.addMessage("messages",
        new FacesMessage(FacesMessage.SEVERITY_INFO, "Nova pessoa criada com sucesso!", ""));

  }

  public Pessoa getPessoaSelecionada() {
    return this.pessoaSelecionada;
  }

  public void setPessoaSelecionada(Pessoa p) {
    this.pessoaSelecionada = p;
  }

  public List<Pessoa> getLista() {
    return this.lista;
  }

  public void setLista(List<Pessoa> lista) {
    this.lista = lista;
  }

  public void salvar() {
    if (this.pessoaSelecionada.getNome().length() > 0
        && !this.lista.contains(this.pessoaSelecionada)) {
      int nextId = this.lista.size();
      this.pessoaSelecionada.setCodigo(nextId);
      this.lista.add(this.pessoaSelecionada);
      // this.pessoaSelecionada = new PessoaFisica();
    }
    FacesContext contexto = FacesContext.getCurrentInstance();
    contexto.addMessage("messages",
        new FacesMessage(FacesMessage.SEVERITY_INFO, "Edição/criação efetuada com sucesso!", ""));
  }

  public void excluirPessoa(Pessoa p) {
    if (this.lista.contains(p)) {
      this.lista.remove(p);
      this.pessoaSelecionada = new PessoaFisica();
      FacesContext.getCurrentInstance().addMessage("messages",
          new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa removida com sucesso!", ""));
    }
  }

  public String cancelar() {
    this.pessoaSelecionada = null;
    this.tipoNovaPessoa = null;
    return "primeiro.jsf";
  }

  public Sexo[] getSexos() {
    return Sexo.values();
  }

  public String getTipoNovaPessoa() {
    return this.tipoNovaPessoa;
  }

  public void setTipoNovaPessoa(String tipoNovaPessoa) {
    this.tipoNovaPessoa = tipoNovaPessoa;
  }

  public boolean isPessoaFisicaSelecionada() {
    return pessoaSelecionada instanceof PessoaFisica;
  }

  public boolean isPessoaJuridicaSelecionada() {
    return pessoaSelecionada instanceof PessoaJuridica;
  }

}
