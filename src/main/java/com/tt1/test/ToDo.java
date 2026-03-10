package com.tt1.test;
/**
 * Representa una tarea (To-Do) dentro del sistema.
 * Contiene información sobre el nombre, descripción, fecha límite
 * y estado de completitud de la tarea.
 */
public class ToDo {
    private String nombre;
    private String descripcion;
    private String fecha;
    private Boolean completado;

    public ToDo() {}

    /**
     * Crea una nueva tarea.
     * La tarea se inicializa como no completada.
     *
     * @param n Nombre identificador de la tarea
     * @param d Descripción detallada de la tarea
     * @param f Fecha límite para completar la tarea
     */
    public ToDo(String n, String d, String f) {
        this.nombre = n;
        this.descripcion = d;
        this.fecha = f;
        this.completado = false;
    }

    /**
     * Devuelve el nombre de la tarea.
     * @return El nombre de la tarea
     */
    public String getNombre() { return this.nombre; }

    /**
     * Establece el nombre de la tarea.
     * @param n El nuevo nombre de la tarea
     */
    public void setNombre(String n) { this.nombre = n; }

    public String getDescripcion() { return this.descripcion; }
    public void setDescripcion(String n) { this.descripcion = n; }

    public String getFecha() { return this.fecha; }
    public void setFecha(String n) { this.fecha = n; }

    public void setCompletado(Boolean n) { this.completado = n; }
    public Boolean getCompletado() { return this.completado; }
}