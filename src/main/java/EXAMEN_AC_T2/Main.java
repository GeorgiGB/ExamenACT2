package EXAMEN_AC_T2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static ConectarBBDD conector;

    public static void main(String[] args) {
        conector = new ConectarBBDD();//conectar la base de datos

        //Barco b = loadBarco("California");
        //b.imprimir();

        //imprimirClasses(2,10);


        conector.closeConexion();//cerrar la conexion

    }

    public static Barco loadBarco(String nomBarco) {
        Barco b = null;

        try {
            Connection con = conector.getLaConexio();

            String sql = "select * from participa p, ships b where p.ship = b.name and name=?;";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, nomBarco);

            ResultSet rs = pst.executeQuery();


            while (rs.next()) {
                if (b == null) {
                    b = new Barco(
                            rs.getString("name"),
                            rs.getString("class"));
                }

                b.addBatalla(new Batalla(rs.getString("battle"), ""));

            }

            rs.close();


        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    public static void imprimirClasses(int min, int max){

        try {

            Connection con=conector.getLaConexio();

            String sql="select * from classes order by numGuns;";

            Statement st=con.createStatement();

            ResultSet rst= st.executeQuery(sql);


            System.out.println(String.format("%-20s%-20s%-20s", "Nom","País","Canyons"));
            for (int i = 0; i < 50; i++) {
                System.out.print("=");
            }

            System.out.println();

            while(rst.next()){
                System.out.println(String.format("%-20s%-20s%-20s",
                        rst.getString("class"),
                        rst.getString("country"),
                        rst.getInt("numGuns")));
            }

            rst.close();

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showNulls(String nomTaula){
        try {
            Connection con=conector.getLaConexio();

            String sql="select * from classes order by ;";

            Statement st=con.createStatement();

            ResultSet rst= st.executeQuery(sql);


            System.out.println(String.format("%-20s", "Camps de la <classes> que poden ser nulls"));
            for (int i = 0; i < 50; i++) {
                System.out.print("=");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void inserirBarco(){
        try{
            Connection con=conector.getLaConexio();

            String sql="INSERTO INTO participa VALUES('?,?,?');";

            Statement st=con.createStatement();

            ResultSet rst= st.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
