import model.Fichaje;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtils;

public class Entrada {
    public static void main(String[] args) {
        Fichaje f1 = new Fichaje(123345, 123545);

        SessionFactory sessionFactory = new HibernateUtils().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(f1);
        session.getTransaction().commit();
    }
}
