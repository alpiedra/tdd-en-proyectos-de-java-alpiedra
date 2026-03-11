package com.tt1.test;

import java.util.List;

/**
 * Capa de lógica de negocio del sistema de tareas.
 * Gestiona la creación, actualización y consulta de tareas,
 * así como el envío de notificaciones por correo al realizar operaciones.
 */
public class Servicio {
    private IRepositorio repositorio;
    private IMailer mailer;

    /**
     * Crea una instancia del servicio con el repositorio y el mailer indicados.
     * @param repositorio Implementación del repositorio de datos
     * @param mailer      Implementación del servicio de envío de correos
     */
    public Servicio(IRepositorio repositorio, IMailer mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }

    public boolean crearTodo(String nombre, String fechaLimite) {
        if (nombre == null || nombre.isEmpty()) return false;
        ToDo todo = new ToDo(nombre, "", fechaLimite);
        boolean guardado = repositorio.guardarTodo(todo);
        if (guardado) mailer.enviarMail();
        return guardado;
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