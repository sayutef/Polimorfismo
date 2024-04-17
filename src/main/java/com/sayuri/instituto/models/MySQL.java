package com.sayuri.instituto.models;

import java.util.ArrayList;

public class MySQL implements BaseDeDatos{

    private ArrayList<Student> lisMySQL;

    public MySQL(){
        lisMySQL = new ArrayList<>();
    }
    @Override
    public void save(Student student) {
        lisMySQL.add(student);
    }

    @Override
    public boolean update(Student studentUpdate) {
        for (int i = 0; i < lisMySQL.size(); i++) {
            Student student = lisMySQL.get(i);
            if ( student.getMatricula() == studentUpdate.getMatricula()){
                lisMySQL.set(i, studentUpdate);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Student> getLisMySQL(){
        return lisMySQL;
    }
}
