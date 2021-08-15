package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.ProyectosPorEstratoDao;
import model.dao.ProyectosPorTipoDao;
import model.dao.ProyectosQuibdoApartaestudioDao;
import model.vo.ProyectosPorEstrato;
import model.vo.ProyectosPorTipo;
import model.vo.ProyectosQuibdoApartaestudio;


//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto4 { 
    //Su codigo
    private final ProyectosPorEstratoDao proyectosPorEstratoDao;
    private final ProyectosPorTipoDao proyectosPorTipoDao;
    private final ProyectosQuibdoApartaestudioDao proyectosQuibdoApartaestudioDao;
    
    public ControladorRequerimientosReto4(){
        //Su codigo
        this.proyectosPorEstratoDao = new ProyectosPorEstratoDao();
        this.proyectosPorTipoDao = new ProyectosPorTipoDao();
        this.proyectosQuibdoApartaestudioDao = new ProyectosQuibdoApartaestudioDao();
    }

    public ArrayList<ProyectosPorEstrato> consultarProyectosPorEstratos() throws SQLException {
        //Su codigo
        return this.proyectosPorEstratoDao.rankingProyectosPorEstrato();
    }
    
    public ArrayList<ProyectosPorTipo> consultarProyectosPorTipos() throws SQLException {
        //Su codigo
        return this.proyectosPorTipoDao.rankingProyectosPorTipo();
    }

    public ArrayList<ProyectosQuibdoApartaestudio> consultarProyectosQuibdoApartaestudios() throws SQLException {
        //Su codigo
        return this.proyectosQuibdoApartaestudioDao.rankingProyectosQuibdoApartaestudios();
    }

}
