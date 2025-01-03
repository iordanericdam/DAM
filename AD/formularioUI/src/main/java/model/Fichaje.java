package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter

@Entity(name = "fichajes")
public class Fichaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int empleado;
    @Column
    private int fichaje;

    public Fichaje(int empleado, int fichaje) {
        this.empleado = empleado;
        this.fichaje = fichaje;
    }
}
