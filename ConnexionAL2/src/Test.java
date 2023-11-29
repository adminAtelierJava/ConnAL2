import java.sql.*;
public class Test {
    private static Connection con;
   static String url = "jdbc:mysql://localhost:3306/esprit";
   static String user = "root";
   static String pwd = "";

   private static Statement ste;
    public static void main(String[] args) {
        try {
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println(con);
            System.out.println("connexion établie");
        }catch (SQLException ex)
        {
            System.out.println(ex);
        }
       try {
           ste = con.createStatement();
           String req="INSERT INTO `personne` (`id`, `nom`, `prenom`, `age`) VALUES (NULL, 'ben fade', 'ons', '12');";
        int res=   ste.executeUpdate(req);

        System.out.println("peronne ajouté");
       }catch (SQLException e){
           System.out.println(e);
       }
       try {
           ResultSet resultSet = ste.executeQuery("select * from personne");
      while (resultSet.next())
      {
          int id=resultSet.getInt("id");
          String nom=resultSet.getString(2);

          String prenom=resultSet.getString(3);
          int age=resultSet.getInt(4);
          System.out.println("id :"+id);
          System.out.println("nom :"+nom);
          System.out.println("prenom :"+prenom);
          System.out.println("age :"+age);
      }

       }catch (SQLException e)
       {
           System.out.println(e);
       }
    }
}
