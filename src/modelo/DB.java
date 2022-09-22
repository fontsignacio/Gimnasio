package modelo;
import java.sql.*;
import java.time.LocalDate;
import modelo.Clientes;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    private String url = "jdbc:mariadb://127.0.0.1/gimnasio";
    private String usr = "root";
    private String clave = "root";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,usr,clave);
    }
    
    private void ejecutar(String sql){
        try {
            Connection c = getConnection();
            Statement s = c.createStatement();
            s.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(sql);               
    }  
    
    public void agregarCliente(String nombre,String actividad,int id_est,String estado){
        String sql = "INSERT INTO cliente(nombre,actividad,Id_est,estado) values ('%1','%2','%3','%4')";      
        sql = sql.replace("%1", nombre);
        sql = sql.replace("%2", actividad);
        sql = sql.replace("%3", Integer.toString(1)); 
        sql = sql.replace("%4", "Abonado");
        ejecutar(sql);
    }
    
    public void agregarCliente(Clientes p){
        agregarCliente(p.getNombre(),p.getActividad(),p.getId_est(),p.getEstado());
    }
 
/*    
    public void modificarCliente(int id,String nombre, String actividad, LocalDate fecha, int id_est, String estado){
        String sql = "UPDATE cliente SET nombre='%1',actividad= '%2',id_est= '%3', estado='%4' WHERE id='%5'";
        sql = sql.replace("%5", Integer.toString(id));
        sql = sql.replace("%1", nombre);
        sql = sql.replace("%2", actividad);        

        LocalDate fecha_actual = LocalDate.now();
        LocalDate fecha30 = fecha.plusDays(30);                
        LocalDate fecha35 = fecha.plusDays(35);
        
        if ((id_est == 1) || (fecha_actual.isBefore(fecha30))){ //abonado
            sql = sql.replace("%3", Integer.toString(1));
            sql = sql.replace("%4", "Abonado");
        }   
        if ((id_est == 2)|| (((fecha_actual.isAfter(fecha30)))&(fecha.isBefore(fecha35)))){ //debe abonar
            sql = sql.replace("%3", Integer.toString(2));
            sql = sql.replace("%4", "Falta Abonar");
        }
        if ((id_est == 3)|| (fecha_actual.isAfter(fecha35))){ //debe abonar
            sql = sql.replace("%3", Integer.toString(3));
            sql = sql.replace("%4", "Deudor");
        }
        
        ejecutar(sql);
    }
    public void modificarCliente(Clientes p){
        modificarCliente(p.getId(),p.getNombre(),p.getActividad(),p.getFecha(),p.getId_est(),p.getEstado());    
    }
  */
    
    public void eliminarCliente(int id){
        String sql = "DELETE FROM cliente WHERE id= '%1'";
        sql = sql.replace("%1", Integer.toString(id));
        ejecutar(sql);    
    }
    
    public Clientes buscar(int id){
        Clientes p = new Clientes();
        try{
            Connection c = getConnection();
            String sql = "SELECT * from cliente where id= '%1'";
            sql = sql.replace("%1", Integer.toString(id));
            ResultSet res = c.createStatement().executeQuery(sql);            
            if (res.next()){
                p.setId(id);
                p.setNombre(res.getString("nombre"));
                p.setActividad(res.getString("Actividad"));
                p.setId_est(res.getInt("id_est"));
                p.setEstado(res.getString("estado"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return p;
    }
         
    
    public ArrayList<Clientes> getClientes(){
        ArrayList<Clientes> clientes = new ArrayList<>();
        try{
            Connection c = getConnection();
            ResultSet res = 
                    c.createStatement()
                            .executeQuery("select * from cliente");
            while (res.next()){
                Clientes p = new Clientes();
                p.setId(res.getInt("id"));
                p.setNombre(res.getString("nombre"));
                p.setActividad(res.getString("Actividad"));
                p.setId_est(res.getInt("id_est"));
                p.setEstado(res.getString("estado"));
                clientes.add(p);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return clientes;
    }
            
}
