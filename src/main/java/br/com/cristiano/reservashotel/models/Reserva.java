package br.com.cristiano.reservashotel.models;

import java.util.Collection;
import java.util.Date;
import java.io.Serializable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Reserva implements Serializable {

    private static final long serialVersionUID = -408558008723379384L;

    private int codigo;
    private Date data;
    private double valor;
    private Pessoa cliente;
    private Collection<DiariaReservada> diarias;
    
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
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @ManyToOne
    @JoinColumn(name = "cod_pessoa")
    public Pessoa getCliente() {
        return cliente;
    }
    
    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }   
    
    @OneToMany(
        mappedBy = "reserva", 
        fetch = FetchType.EAGER, 
        cascade = CascadeType.ALL
    )
    public Collection<DiariaReservada> getDiarias() {
        return this.diarias;
    }

    public void setDiarias(Collection<DiariaReservada> diarias) {
        this.diarias = diarias;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        long temp;
        temp = Double.doubleToLongBits(valor);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((diarias == null) ? 0 : diarias.hashCode());
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
        Reserva other = (Reserva) obj;
        if (codigo != other.codigo)
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (diarias == null) {
            if (other.diarias != null)
                return false;
        } else if (!diarias.equals(other.diarias))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reserva [codigo=" + codigo + ", data=" + data + ", valor=" + valor + ", cliente=" + cliente
                + ", diarias=" + diarias + "]";
    }
    
    
}

