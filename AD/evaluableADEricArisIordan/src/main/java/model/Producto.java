package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Producto implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private int cantidadd;
    private double precio;

    public Producto(String nombre, String descripcion, int cantidadd, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadd = cantidadd;
        this.precio = precio;
    }

    public void mostrarDatos(){
        System.out.println("id = " + id);
        System.out.println("nombre = " + nombre);
        System.out.println("descripcion = " + descripcion);
        System.out.println("cantidadd = " + cantidadd);
        System.out.println("precio = " + precio);
    }


}
