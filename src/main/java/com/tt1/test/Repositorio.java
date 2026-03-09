package com.tt1.test;
import java.util.List;
import java.util.stream.Collectors;
import com.tt1.test.IRepositorio;
public class Repositorio implements IRepositorio{

    private DBStub db;

    public Repositorio(DBStub db) {
        this.db = db;
    }

    public boolean guardarTodo(ToDo todo) {
        return db.crearTodo(todo);
    }

    public ToDo encontrarTodo(String nombre) {
        return db.buscarTodo(nombre);
    }

    public boolean marcarComoCompletada(String nombre) {
        ToDo todo = db.buscarTodo(nombre);
        if (todo == null) return false;
        todo.setCompletado(true);
        return db.actualizarTodo(todo);
    }

    public List<ToDo> obtenerPendientes() {
        return db.getTodos().stream()
                .filter(t -> !t.getCompletado())
                .collect(Collectors.toList());
    }

    public boolean guardarEmail(String email) {
        return db.anadirEmail(email);
    }

    public List<String> getEmails() {
        return db.getEmails();
    }
}