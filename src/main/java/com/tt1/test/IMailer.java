package com.tt1.test;

/**
 * Interfaz para el servicio de envío de correos electrónicos.
 * Permite desacoplar la lógica de negocio de la implementación concreta del mailer.
 */
public interface IMailer {

    /**
     * Envía un correo electrónico.
     * @return {@code true} si el envío fue exitoso, {@code false} en caso contrario
     */
    Boolean enviarMail();
}