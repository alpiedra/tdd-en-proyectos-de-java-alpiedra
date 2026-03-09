package com.tt1.test;

import java.util.List;

public class Servicio {
    private IRepositorio repositorio;
    private IMailer mailer;

    public Servicio(IRepositorio repositorio, IMailer mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }

    public boolean crearTodo(String nombre, String fechaLimite) {
        if (nombre == null || nombre.isEmpty()) return false;
        ToDo todo = new ToDo(nombre, "", fechaLimite);
        return repositorio.guardarTodo(todo);
    }

    public boolean anadirEmail(String email) {
        if (email == null || !email.contains("@")) return false;
        return repositorio.guardarEmail(email);
    }

    public boolean marcarCompletada(String nombre) {
        return repositorio.marcarComoCompletada(nombre);
    }

    public List<ToDo> listarPendientes() {
        return repositorio.obtenerPendientes();
    }
}