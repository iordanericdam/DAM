import dao.EmpleadoDAO;
import dao.PedidoDAO;
import dao.ProductoDAO;
import dao.ProductoFavDao;
import model.Empleado;
import model.Pedido;
import model.ProductoFav;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) throws Exception {
        EmpleadoDAO empleadoDAO  = new EmpleadoDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        ProductoFavDao productoFavDao = new ProductoFavDao();
        Scanner sc = new Scanner(System.in);
        ResultSet resultSet;
        productoDAO.importData(); // Agreaga los productos de la API a la bbdd (si no estan ya)
        int opcion;


       do {
               System.out.println("\n===== Menú Principal =====");
               System.out.println("1. Agregar una serie de empleados.");
               System.out.println("2. Agregar una serie de pedidos.");
               System.out.println("3. Mostrar todos los empleados.");
               System.out.println("4. Mostrar todos los productos.");
               System.out.println("5. Mostrar todos los pedidos.");
               System.out.println("6. Mostrar todos los productos de menos de 600€.");
               System.out.println("7. Insertar en productos_fav > 1000.");
               System.out.println("8. Mostrar todos los productos favoritos");
               System.out.println("9. Salir.");
               System.out.print("Seleccione una opción: ");
               opcion = sc.nextInt();

               switch (opcion){
                   case 1:
                       System.out.println("Añadir empleados");
                       for (int i = 1;i<3;i++){
                           System.out.println("Introduce el nombre del "+ i + " empleado");
                           String nombre = sc.next();
                           System.out.println("Introduce el primer apellido del "+ i + " empleado");
                           String apellido = sc.next();
                           System.out.println("Introduce el correo del "+ i + " empleado");
                           String correo = sc.next();

                           Empleado e1 = new Empleado(nombre, apellido, correo);
                           empleadoDAO.crearEmpleado(e1);
                       }
                       break;
                   case 2:
                       boolean pedidoRealizado = false;
                       for (int i = 0; i<2;i++) {
                           System.out.println(i);
                           pedidoRealizado = false;
                           while (!pedidoRealizado) {
                               productoDAO.showProducts();
                               System.out.println("Introduce el id del producto que quieres comprar.");
                               int id_producto = sc.nextInt();
                               try {
                                   resultSet = productoDAO.selectProduct(id_producto);
                               } catch (SQLException e) {
                                   throw new RuntimeException(e);
                               }
                               if (resultSet.next()) {
                                   String descripcion = resultSet.getString("descripcion");
                                   double precio_total = resultSet.getDouble("precio");
                                   Pedido p1 = new Pedido(id_producto, descripcion, precio_total);
                                   boolean pedidoCreado = pedidoDAO.createOrder(p1);
                                   System.out.println(pedidoCreado ? "Error al grabar el pedido." : "El pedido se grabó correctamente.");
                                   pedidoRealizado = true;
                               } else {
                                   System.out.println("El id del producto no esta disponible");
                               }
                           }
                       }
                       break;
                   case 3:
                       System.out.println("Mostrar Todos los empleados:");
                       try {
                           resultSet = empleadoDAO.mostrarEmpleados();
                       } catch (SQLException e) {
                           throw new RuntimeException(e);
                       }
                       while (resultSet.next()) {

                           int id = resultSet.getInt("id");
                           String nombre = resultSet.getString("nombre");
                           String apellidos = resultSet.getString("apellidos");
                           String correo = resultSet.getString("correo");

                           // Mostrar los datos en la consola
                           System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Correo: " + correo);
                       }
                       break;
                   case 4:
                       System.out.println("Productos: ");
                       productoDAO.showProducts();
                       break;
                   case 5:
                       pedidoDAO.showOrders();
                       break;
                   case 6:
                       System.out.println("Productos inferiores a 600€");
                       productoDAO.showProductsBaratos();
                       break;
                   case 7:
                       try {
                           resultSet = productoDAO.selectFavourite();
                       } catch (SQLException e) {
                           throw new RuntimeException(e);
                       }
                       while (resultSet.next()) {
                           int id = resultSet.getInt("id");
                           ProductoFav f1 = new ProductoFav(id);
                           productoFavDao.insertProduct(f1);
                       }

                       break;
                   case 8: System.out.println("Adios ;)");
                       productoFavDao.showData();
                       break;
                   case 9:
                       System.out.println("Adios ;)");
                       break;
                   default:
                       System.out.println("Opcion incorrecta.");
               }
           } while (opcion != 9);
       }
    }
