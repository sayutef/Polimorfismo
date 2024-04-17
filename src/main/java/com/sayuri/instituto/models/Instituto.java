package com.sayuri.instituto.models;

import java.util.ArrayList;

public class Instituto {

    private MySQL baseDeDatos;
    private OracleDataBase baseDeDatos1;
    private PostgreSQL baseDeDatos2;
    private ArrayList<BaseDeDatos> listGeneral = new ArrayList<>();
    public Instituto(BaseDeDatos baseDeDatos) {
        this.baseDeDatos = new MySQL();
        baseDeDatos1 = new OracleDataBase();
        baseDeDatos2 = new PostgreSQL();

        listGeneral.add(this.baseDeDatos);
        listGeneral.add(baseDeDatos1);
        listGeneral.add(baseDeDatos2);
    }

    public void save(Student student){
            for (BaseDeDatos imprimir : listGeneral){
                imprimir.save(student);
            }
    }
    public void updateAll(Student student){
        for (BaseDeDatos imprimir : listGeneral){
            imprimir.update(student);
        }
    }

    public MySQL getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(MySQL baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public OracleDataBase getBaseDeDatos1() {
        return baseDeDatos1;
    }

    public void setBaseDeDatos1(OracleDataBase baseDeDatos1) {
        this.baseDeDatos1 = baseDeDatos1;
    }

    public PostgreSQL getBaseDeDatos2() {
        return baseDeDatos2;
    }

    public void setBaseDeDatos2(PostgreSQL baseDeDatos2) {
        this.baseDeDatos2 = baseDeDatos2;
    }
}