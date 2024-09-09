package br.com.cristiano.reservashotel.models;


import java.io.Serializable;
import java.util.Collection;
import java.lang.String;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Pessoa implements Serializable {

	
	private static final long serialVersionUID = 4069917727164404058L;
	private int codigo;
	private String nome;
	private String telefone;
	private String email;
	private Endereco endereco;
	private Collection<Reserva> reservas;

	@OneToMany(mappedBy = "cliente")
	public Collection<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Collection<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Embedded
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Pessoa() {
		super();
	}   

	@Id   
	@GeneratedValue(generator = "genpessoa")
	@SequenceGenerator(sequenceName = "pessoa_codigo_seq", name = "genpessoa")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}   
	
	@Column(unique = true, nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    @Override
    public boolean equals(Object obj) {
        if (this != obj) {
            return false;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pessoa p = (Pessoa) obj;

        return codigo == p.getCodigo() && Objects.equals(p.getEmail(), email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nome, email, telefone, codigo);
    }
   
}

