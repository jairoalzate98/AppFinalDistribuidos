package model;

import java.util.ArrayList;

public class EstudianteManager {

    private ArrayList<Estudiante> estudianteList;

    public EstudianteManager(){
        estudianteList = new ArrayList<>();
        estudianteList.add(new Estudiante(201611393, "a123", "Manuel"));
    }

    public boolean validateEstudiante(int id, String password){
        for (Estudiante est: estudianteList) {
            if (est.getId() == id && est.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

}
