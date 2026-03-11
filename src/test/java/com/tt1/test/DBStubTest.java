package com.tt1.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DBStubTest {

    private DBStub db;

    @BeforeEach
    void setUp() {
        db = new DBStub();
    }

    @AfterEach
    void tearDown() {
        db = null;
    }

    @Test
    void testCrearYBuscarTodo() {
        ToDo todo = new ToDo("Leer", "Libro de Java", "2025-07-01");
        db.crearTodo(todo);
        assertEquals(todo, db.buscarTodo("Leer"));
    }

    @Test
    void testBuscarTodoInexistenteDevuelveNull() {
        assertNull(db.buscarTodo("NoExiste"));
    }

    @Test
    void testGetTodosDevuelveLista() {
        db.crearTodo(new ToDo("T1", "desc", "2025-07-01"));
        db.crearTodo(new ToDo("T2", "desc", "2025-07-01"));
        assertEquals(2, db.getTodos().size());
    }

    @Test
    void testAñadirEmail() {
        assertTrue(db.anadirEmail("test@test.com"));
        assertEquals(1, db.getEmails().size());
    }

    @Test
    void testAñadirEmailNuloDevuelveFalse() {
        assertFalse(db.anadirEmail(null));
    }
}