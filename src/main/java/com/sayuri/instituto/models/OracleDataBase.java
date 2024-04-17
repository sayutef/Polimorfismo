package com.sayuri.instituto.models;

import java.util.ArrayList;

public class OracleDataBase implements BaseDeDatos{

    private ArrayList<Student>listOracle;
    public OracleDataBase(){
        listOracle = new ArrayList<>();
    }

    @Override
    public void save(Student student) {
        listOracle.add(student);
    }

    @Override
    public boolean update(Student studentUpdate) {
        for (int i = 0; i < listOracle.size(); i++) {
            Student student = listOracle.get(i);
            if ( student.getMatricula() == studentUpdate.getMatricula()){
                listOracle.set(i, studentUpdate);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Student>getListOracle(){
        return listOracle;
    }
}
