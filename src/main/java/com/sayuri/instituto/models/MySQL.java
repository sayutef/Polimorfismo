package com.sayuri.instituto.models;

import java.util.ArrayList;

public class MySQL implements BaseDeDatos{
    @Override
    public void save(Student student) {
        System.out.println("Guardando estudiante MySQL ");
    }

    @Override
    public void update(Student student) {
        System.out.println("Actualizando estudiante ");
    }
}
