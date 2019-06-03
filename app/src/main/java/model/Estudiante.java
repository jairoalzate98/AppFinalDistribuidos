package model;

public class Estudiante {
    private int id;
    private String password;
    private String name;

    public Estudiante(int id, String password, String name){
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return id + "-" + password + "-" + name;
    }
}
