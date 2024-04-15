package com.sayuri.instituto.models;

public class PostgreSQL implements BaseDeDatos{
    @Override
    public void save(Student student) {
        System.out.println("Guardando estudiante PostgreSQL");
    }
    @Override
    public void update(Student student) {
        System.out.println("Actualizando estudiante ");
    }
}
