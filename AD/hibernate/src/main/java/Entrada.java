import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtils;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        String nombre, apellido, correo;
        int telefono;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre: ");
        nombre = sc.next();
        System.out.print("Introduce el apellido: ");
        apellido = sc.next();
        System.out.print("Introduce el correo: ");
        correo = sc.next();
        System.out.print("Introduce el telefono: ");
        telefono = sc.nextInt();
        Trabajador t1 = new Trabajador(nombre, apellido, correo, telefono);

        System.out.println(t1.getName());

        SessionFactory sessionFactory = new HibernateUtils().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(t1);
        session.getTransaction().commit();
    }
}
