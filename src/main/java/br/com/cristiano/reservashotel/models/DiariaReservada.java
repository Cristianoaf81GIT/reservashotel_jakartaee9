package br.com.cristiano.reservashotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DiariaReservada extends Diaria {
    
    private Reserva reserva;

    public DiariaReservada() {
        super();
    }
    
    @ManyToOne
    @JoinColumn(name = "cod_reserva")
    public Reserva getReserva() {
        return this.reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((reserva == null) ? 0 : reserva.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        DiariaReservada other = (DiariaReservada) obj;
        if (reserva == null) {
            if (other.reserva != null)
                return false;
        } else if (!reserva.equals(other.reserva))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DiariaReservada [reserva=" + reserva + "]";
    }
 
}
