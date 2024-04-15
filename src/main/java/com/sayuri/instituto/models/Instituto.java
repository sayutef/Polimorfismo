package com.sayuri.instituto.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Instituto {
   private ArrayList<Student> listStudents = new ArrayList<>();
    private BaseDeDatos baseDeDatos;

    public Instituto() {
    }

    public boolean save (Student student){
        return listStudents.add(student);
    }
    public boolean update (Student updatedStudent){
        for (int i = 0; i < listStudents.size(); i++) {
            Student student = listStudents.get(i);
            if ( student.getMatricula() == updatedStudent.getMatricula()){
                listStudents.set(i, updatedStudent);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<Student> listStudents) {
        this.listStudents = listStudents;
    }
    public Instituto(BaseDeDatos baseDeDatos){
        this.baseDeDatos = baseDeDatos;
    }
    public void crearRegistro(Student student){
        baseDeDatos.save(student);
    }
    public void updateRegistro(Student student){
        baseDeDatos.update(student);
    }
    public void mostrarRegistros(){
        for (Student student : listStudents) {
            System.out.println(student);
        }
    }

    public BaseDeDatos getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(BaseDeDatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

}
