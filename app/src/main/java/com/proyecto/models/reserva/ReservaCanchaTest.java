package com.proyecto.models.reserva;

import androidx.room.Embedded;

import com.proyecto.models.cancha.Cancha;

public class ReservaCanchaTest {
    @Embedded
    Reserva reserva;

    @Embedded
    Cancha cancha;

    public Reserva getReserva() {
        return reserva;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }
}
