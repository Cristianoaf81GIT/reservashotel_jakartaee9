package br.com.cristiano.reservashotel.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import br.com.cristiano.reservashotel.models.Pessoa;
import br.com.cristiano.reservashotel.models.PessoaFisica;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("cadastroPessoaBean")
@SessionScoped
public class CadastroPessoaBean implements Serializable {

    private static final long serialVersionUID = -7600674761430266600L;

    private Pessoa pessoalSelecionada;
    private Collection<Pessoa> lista;


    public CadastroPessoaBean() {
        this.pessoalSelecionada = new PessoaFisica();
        this.lista = new ArrayList<Pessoa>();
    }


    public Pessoa getPessoaSelecionada() {
        return this.pessoalSelecionada;
    }

    public void setPessoalSelecionada(Pessoa p) {
        this.pessoalSelecionada = p;
    }

    public Collection<Pessoa> getList() {
        return this.lista;
    }

    public void setList(Collection<Pessoa> lista) {
        this.lista = lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            return false;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CadastroPessoaBean pc = (CadastroPessoaBean) o;

        return pessoalSelecionada.getEmail() == pc.getPessoaSelecionada().getEmail() &&
            pc.getPessoaSelecionada().getCodigo() == pessoalSelecionada.getCodigo() &&
            Objects.equals(lista, pc.lista);
    }


    @Override
    public int hashCode() {
        return Objects.hash(pessoalSelecionada, lista);
    }

    public void submit() {
        System.out.println("Nome: " + this.pessoalSelecionada.getNome());
        System.out.println("Email: " + this.pessoalSelecionada.getEmail());
        System.out.println("Telefone: " + this.pessoalSelecionada.getTelefone());
    }

}
