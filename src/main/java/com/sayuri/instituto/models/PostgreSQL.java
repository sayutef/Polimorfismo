package com.sayuri.instituto.models;

import java.util.ArrayList;

public class PostgreSQL implements BaseDeDatos{
    private ArrayList<Student>listPostgre;

    public PostgreSQL(){
        listPostgre = new ArrayList<>();
    }
    @Override
    public void save(Student student){
        listPostgre.add(student);
    }
    @Override
    public boolean update(Student studentUpdate) {
        for (int i = 0; i < listPostgre.size(); i++) {
            Student student = listPostgre.get(i);
            if ( student.getMatricula() == studentUpdate.getMatricula()){
                listPostgre.set(i, studentUpdate);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Student>getListPostgre(){
        return listPostgre;
    }
}
