package com.sayuri.instituto.models;

public class OracleDataBase implements BaseDeDatos{
    @Override
    public void save(Student student) {
        System.out.println("Guardando estudiante OracleDataBase");
    }

    @Override
    public void update(Student student) {
        System.out.println("Actualizando estudiante ");
    }
}
