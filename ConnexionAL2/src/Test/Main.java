package Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Entite.Personne;
import Services.ServicePersonne;
import Utils.DataSource;
public class Main {
    public static void main(String[] args) {

        ServicePersonne ser=new ServicePersonne();
        Personne p1=new Personne("test1","trst",12);

        try {
            ser.ajouter(p1);
            System.out.println("personne ajouté");
        }catch (SQLException e)
        {
            System.out.println(e);
        }


        ArrayList<Personne> l=null;
        try {
            l = ser.readAll();
        }catch (SQLException e)
        {
            System.out.println(e);
        }


        l.forEach(e-> System.out.println(e));
    }
}
