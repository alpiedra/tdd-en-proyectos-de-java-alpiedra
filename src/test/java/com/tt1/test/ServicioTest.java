package com.tt1.test;

import com.tt1.test.Mocks.MMailer;
import com.tt1.test.Mocks.MRepositorio;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ServicioTest {

    private Servicio servicio;

    @BeforeEach
    void setUp() {
        servicio = new Servicio(new MRepositorio(), new MMailer());
    }

    @AfterEach
    void tearDown() {
        servicio = null;
    }

    @Test
    void testCrearTodoDevuelveTrue() {
        assertTrue(servicio.crearTodo("Estudiar", "2025-08-01"));
    }

    @Test
    void testAñadirEmailDevuelveTrue() {
        assertTrue(servicio.anadirEmail("alumno@uni.es"));
    }

    @Test
    void testMarcarCompletadaDevuelveTrue() {
        servicio.crearTodo("Tarea", "2025-08-01");
        assertTrue(servicio.marcarCompletada("Tarea"));
    }

    @Test
    void testListarPendientesDevuelveSoloNoCompletadas() {
        servicio.crearTodo("Pendiente", "2025-08-01");
        servicio.crearTodo("Hecha", "2025-08-01");
        servicio.marcarCompletada("Hecha");

        List<ToDo> pendientes = servicio.listarPendientes();
        assertEquals(1, pendientes.size());
        assertEquals("Pendiente", pendientes.get(0).getNombre());
    }
}