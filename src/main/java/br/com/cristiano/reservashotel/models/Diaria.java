package br.com.cristiano.reservashotel.models;

import java.util.Date;
import java.util.Collection;
import java.io.Serializable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Diaria implements Serializable {

    private static final long serialVersionUID = -689713915210189927L;

    private int codigo;
    private Date data;
    private Collection<PessoaFisica> hospedes;
    
    @ManyToMany
    @JoinTable(
        name = "hospedagem", 
        joinColumns = @JoinColumn(name = "cod_diaria"),
        inverseJoinColumns = @JoinColumn(name = "cod_pessoa")
    )
    public Collection<PessoaFisica> getHospedes() {
        return hospedes;
    }

    public void setHospedes(Collection<PessoaFisica> hospedes) {
        this.hospedes = hospedes;
    }

    @Id
    @GeneratedValue
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Date getData() {
        return data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Diaria other = (Diaria) obj;
        if (codigo != other.codigo)
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        return true;
    } 

    

}
