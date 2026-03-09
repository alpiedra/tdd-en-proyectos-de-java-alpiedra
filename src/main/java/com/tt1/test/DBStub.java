package com.tt1.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBStub {

    private Map<String, ToDo> tareas = new HashMap<>();
    private List<String> emails = new ArrayList<>();

    public boolean crearTodo(ToDo todo) {
        if (todo == null || todo.getNombre() == null) return false;
        tareas.put(todo.getNombre(), todo);
        return true;
    }

    public ToDo buscarTodo(String nombre) {
        return tareas.get(nombre);
    }

    public List<ToDo> getTodos() {
        return new ArrayList<>(tareas.values());
    }

    public boolean actualizarTodo(ToDo todo) {
        if (!tareas.containsKey(todo.getNombre())) return false;
        tareas.put(todo.getNombre(), todo);
        return true;
    }

    public boolean eliminarTodo(String nombre) {
        return tareas.remove(nombre) != null;
    }
    public boolean anadirEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        emails.add(email);
        return true;
    }

    public List<String> getEmails() {
        return new ArrayList<>(emails);
    }
}