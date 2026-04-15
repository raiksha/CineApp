package service;

import model.Cliente;
import model.Funcion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CineService {

    private static Scanner scanner = new Scanner(System.in);

public class CineService {

    private List<Cliente> listaClientes;
    private List<Funcion> listaFunciones;

    // Constructor
    public CineService() {
        this.listaClientes = new ArrayList<>();
        this.listaFunciones = new ArrayList<>();
    }

    // Getters y setters
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Funcion> getListaFunciones() {
        return listaFunciones;
    }

    public void setListaFunciones(List<Funcion> listaFunciones) {
        this.listaFunciones = listaFunciones;
    }

    //do-while
    int opcion;
    boolean activo = true;

    llenarDatos();

        do

    {
        mostrarMenuService();
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {


            case 1 -> {
                crearCliente();
            }

            case 2 -> {
                verCartelera();
            }

            case 3 -> {
                comprarEntrada();
            }

            case 4 -> {
                verEntradasCliente();
            }

            case 0 -> {
                salir();
            }

            default -> System.out.println("⚠ Opción inválida");
        }

        if (activo) {
            System.out.println("Presiona ENTER para continuar...");
            scanner.nextLine();
            scanner.nextLine();
        }

    } while(opcion !=0);

        scanner.close();
}

    // Métodos del servicio
    public void mostrarMenuService() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║        ===      CINE APP      ===      ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║   1. Crear cliente                     ║");
        System.out.println("║   2. Ver cartelera                     ║");
        System.out.println("║   3. Comprar entrada                   ║");
        System.out.println("║   4. Ver entradas del cliente          ║");
        System.out.println("║   0. Salir                             ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║         Seleccione una opción          ║");
        System.out.println("╚════════════════════════════════════════╝");
    // Métodos del servicio
    public void mostrarMenuService() {
        // Diego 
    }

    public void crearCliente() {
        // Angela 
    }

    public void verCartelera() {
        // Julio
    }

    public void comprarEntrada() {

        if (listaClientes.isEmpty()) {
            System.out.println("Agrega un cliente primero.");
            return;
        } else if (listaFunciones.isEmpty()) {
            System.out.println("Agrega una función primero.");
            return;
        }

        // Mostrar funciones disponibles
        for (int i = 0; i < listaFunciones.size(); i++) {
            Funcion f = listaFunciones.get(i);
            System.out.println(i + " - " + f.getPelicula().getTitulo() + " | " + f.getHorario());
        }

        System.out.print("Elige una función: ");
        int indFuncion = Main.scanner.nextInt(); // Hay que cambiar en Main.java, poner el scanner "public" para poder usarlo así
        Main.scanner.nextLine(); // Limpiar buffer scanner
        Funcion funcion = listaFunciones.get(indFuncion);

        if (funcion.getAsientosDisponibles() == 0) {
            System.out.println("No hay asientos disponibles.");
            return;
        }

        // Pedir asiento hasta elegir uno libre
        int numeroAsiento;
        while (true) {
            System.out.println("Asientos disponibles: " + funcion.getAsientosDisponibles());
            System.out.print("Elige tu asiento (número): ");
            numeroAsiento = Main.scanner.nextInt();
            Main.scanner.nextLine(); // Limpiar buffer scanner

            // Verificar que el asiento no haya sido vendido ya
            boolean vendido = false;
            for (Entrada e : funcion.getEntradasVendidas()) {
                if (e.getNumeroAsiento() == numeroAsiento) {
                    vendido = true;
                    break;
                }
            }

            if (vendido) {
                System.out.println("Ese asiento ya se vendió, escoge otro.");
            } else {
                break;
            }
        }

        // Mostrar clientes y elegir a quién pertenece la entrada
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println(i + " - " + listaClientes.get(i).getNombre());
        }
        System.out.print("Elige el cliente: ");
        int indCliente = Main.scanner.nextInt();
        Main.scanner.nextLine(); // Limpiar buffer scanner
        Cliente cliente = listaClientes.get(indCliente);

        Entrada entrada = new Entrada(cliente, funcion, numeroAsiento);
        cliente.agregarEntrada(entrada);
        funcion.setEntradasVendidas(funcion.getEntradasVendidas() + 1);

        System.out.println("¡Ya compraste tu entrada!");
        System.out.println("Volviendo al menú principal...");
    }

    public void verEntradasCliente() {
        // Alexander
    }

    public void salir() {
        // Sary
    }
}