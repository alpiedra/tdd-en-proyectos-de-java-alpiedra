package com.tt1.test;

import com.tt1.test.Mocks.MMailer;
import com.tt1.test.Mocks.MRepositorio;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ServicioTest {

    private Servicio servicio;
    private MMailer mMailer;
    private MRepositorio mRepositorio;

    @BeforeEach
    void setUp() {
        mMailer = new MMailer();
        mRepositorio = new MRepositorio();
        servicio = new Servicio(mRepositorio, mMailer);
    }

    @AfterEach
    void tearDown() {
        servicio = null;
        mMailer = null;
        mRepositorio = null;
    }

    @Test
    void testCrearTodoDevuelveTrue() {
        assertTrue(servicio.crearTodo("Ejemplo", "2026-10-03"));
    }

    @Test
    void testCrearTodoLlamaAlMailer() {
        servicio.crearTodo("Ejemplo", "2026-10-03");
        assertTrue(mMailer.seEnvio());
    }

    @Test
    void testCrearTodoNombreNuloNoLlamaAlMailer() {
        servicio.crearTodo(null, "2026-10-03");
        assertFalse(mMailer.seEnvio());
    }

    @Test
    void testAñadirEmailDevuelveTrue() {
        assertTrue(servicio.anadirEmail("ejemplo@gmail.com"));
    }

    @Test
    void testAñadirEmailInvalidoDevuelveFalse() {
        assertFalse(servicio.anadirEmail("correo"));
    }

    @Test
    void testMarcarCompletadaDevuelveTrue() {
        servicio.crearTodo("Tarea", "2026-10-03");
        assertTrue(servicio.marcarCompletada("Tarea"));
    }

    @Test
    void testListarPendientesDevuelveSoloNoCompletadas() {
        servicio.crearTodo("Pendiente", "2026-10-03");
        servicio.crearTodo("Hecha", "2026-10-03");
        servicio.marcarCompletada("Hecha");

        List<ToDo> pendientes = servicio.listarPendientes();
        assertEquals(1, pendientes.size());
        assertEquals("Pendiente", pendientes.get(0).getNombre());
    }

    @Test
    void testMailerSeResetea() {
        servicio.crearTodo("Tarea", "2026-10-03");
        assertTrue(mMailer.seEnvio());
        mMailer.reset();
        assertFalse(mMailer.seEnvio());
    }
}