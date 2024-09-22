package br.com.cristiano.reservashotel.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import br.com.cristiano.reservashotel.enums.Sexo;
import br.com.cristiano.reservashotel.models.Pessoa;
import br.com.cristiano.reservashotel.models.PessoaFisica;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("cadastroPessoaBean")
@SessionScoped
public class CadastroPessoaBean implements Serializable {

    private static final long serialVersionUID = -7600674761430266600L;

    private Pessoa pessoalSelecionada;
    private List<Pessoa> lista;

    public CadastroPessoaBean() {
        this.pessoalSelecionada = new PessoaFisica();
        this.lista = new ArrayList<Pessoa>();
        for (int x = 0; x < 10; x++){
            PessoaFisica p = new PessoaFisica();
            p.setNome(String.format("fulano %02d", x));
            p.setEmail(String.format("fulano%02d@email.com", x));
            p.setTelefone(String.format("999.88%2d", x));
            p.setRg(String.format("0000000-%02d",x));
            p.setCpf(String.format("000-000-111-sp-%02d",x));            
            p.setSexo(Sexo.M);
            p.setCodigo(x);
            this.lista.add(p);
        }
    }


    public Pessoa getPessoaSelecionada() {
        return this.pessoalSelecionada;
    }

    public void setPessoalSelecionada(Pessoa p) {
        this.pessoalSelecionada = p;
    }

    public List<Pessoa> getLista() {
        return this.lista;
    }

    public void setLista(List<Pessoa> lista) {
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
        if (
            this.pessoalSelecionada.getNome().length() > 0 && 
            !this.lista.contains(this.pessoalSelecionada)
        ) {
            int nextId = this.lista.size();
            this.pessoalSelecionada.setCodigo(nextId);
            this.lista.add(this.pessoalSelecionada);
        }
    }

}
