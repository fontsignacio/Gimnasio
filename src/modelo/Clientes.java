package modelo;
import java.time.LocalDate;

public class Clientes {
    private int id;
    private String nombre;
    private String actividad;
    private LocalDate fecha;
    private int id_est;
    private String estado;
    
    public Clientes() {
    
    }
   
    public Clientes(int id, String nombre, String actividad, LocalDate fecha, int id_est, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.actividad = actividad;
        this.fecha = fecha;
        this.id_est = id_est;
        this.estado = estado;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public int getId_est() {
        return id_est;
    }

    public void setId_est(int id_est) {
        this.id_est = id_est;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
  
    
    
    @Override
    public String toString() {
        return "Clientes{" + "id=" + id + ", nombre=" + nombre + ", actividad=" + actividad + ", fecha=" + fecha + ", id_est=" + id_est + ", estado=" + estado + '}';
    }

}
