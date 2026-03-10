package com.tt1.test;

import java.util.List;
/**
 * Interfaz que define las operaciones de persistencia del sistema de tareas.
 * Cualquier implementación de repositorio debe ser capaz de almacenar,
 * recuperar y gestionar tareas y direcciones de correo electrónico.
 */
public interface IRepositorio {
    /**
     * Guarda una nueva tarea en el repositorio.
     * @param todo La tarea a guardar
     * @return {@code true} si se guardó correctamente, {@code false} en caso contrario
     */
    boolean guardarTodo(ToDo todo);    ToDo encontrarTodo(String nombre);
    boolean marcarComoCompletada(String nombre);
    List<ToDo> obtenerPendientes();
    boolean guardarEmail(String email);
    List<String> getEmails();
}