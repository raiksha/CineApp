package service;

import model.Cliente;
import model.Funcion;

import java.util.ArrayList;
import java.util.List;

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
        // Constanza
    }

    public void verEntradasCliente() {
        // Alexander
    }

    public void salir() {
        // Sary
    }
}