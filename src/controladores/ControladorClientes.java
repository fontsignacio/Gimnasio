package controladores;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

public class ControladorClientes {
    static DB db = new DB();
    static VistaCliente ventana = new VistaCliente();
    
    public static void mostrar(){
        ventana.setVisible(true);
        cargarTabla();
    }
       
    public static void cargarTabla(){
        DefaultTableModel datos = (DefaultTableModel) ventana.getjTable1().getModel();
        datos.setNumRows(0);
        for (Clientes p : db.getClientes() ) {
            Object[] fila = new Object[6];
            fila[0] = p.getId();
            fila[1] = p.getNombre();
            fila[2] = p.getActividad();
            fila[3] = p.getFecha();
            fila[4] = p.getId_est();
            fila[5] = p.getEstado();
            datos.addRow(fila);
        }
    }
    
    
    public static void botonAgregar() {        
        String nombre = ventana.getNombre().getText();
        String actividad = ventana.getActividad().getText();
        int id_est = Integer.parseInt(ventana.getId_est().getText());
        String estado = ventana.getEstado().getText();
        db.agregarCliente(nombre, actividad,id_est,estado);
        cargarTabla();
    }
/*    
    public static void botonModificar() {
        int id = Integer.parseInt(ventana.getId().getText());
        String nombre = ventana.getNombre().getText();
        String actividad = ventana.getActividad().getText();
        int id_est = Integer.parseInt(ventana.getId_est().getText());
        String estado = ventana.getEstado().getText();
        
        db.modificarCliente(id,nombre,actividad,id_est,estado);
        cargarTabla();
    }*/
    
    public static void botonBuscar(){
        int id = Integer.parseInt(ventana.getId().getText());
        Clientes p = db.buscar(id);        
        ventana.getNombre().setText(p.getNombre());
        ventana.getActividad().setText(p.getActividad());
        ventana.getId_est().setText( Integer.toString(p.getId_est()) );
        ventana.getEstado().setText(p.getEstado());
    }
    
      
    public static void botonEliminar() {
        int id = Integer.parseInt(ventana.getId().getText());    
        db.eliminarCliente(id);
        cargarTabla(); 
    }
      
}
