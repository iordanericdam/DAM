package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "trabajadores")
public class Trabajador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private  String email;
    @Column(name = "phone")
    private int telefono;

    public Trabajador(String name, String surname, String email, int telefono) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telefono = telefono;
    }
}
