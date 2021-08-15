package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.ProyectosQuibdoApartaestudio;

public class ProyectosQuibdoApartaestudioDao {
   
    public ArrayList<ProyectosQuibdoApartaestudio> rankingProyectosQuibdoApartaestudios() throws SQLException {
        //su codigo
        ArrayList<ProyectosQuibdoApartaestudio> respuesta = new ArrayList<ProyectosQuibdoApartaestudio>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "select ID_Proyecto, Constructora, Porcentaje_Cuota_Inicial, Acabados "+
                                "from Proyecto p "+
                                "where Clasificacion = 'Apartaestudio' and Ciudad = 'Quibdo' ";


            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultSet.next()){
                ProyectosQuibdoApartaestudio proyectosPorQuibdoApartaestudio = new ProyectosQuibdoApartaestudio();
                proyectosPorQuibdoApartaestudio.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                proyectosPorQuibdoApartaestudio.setConstructora(resultSet.getString("Constructora"));
                proyectosPorQuibdoApartaestudio.setPorcentajeCuotaInicial(resultSet.getFloat("Porcentaje_Cuota_Inicial"));
                proyectosPorQuibdoApartaestudio.setAcabados(resultSet.getString("Acabados"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(proyectosPorQuibdoApartaestudio);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los proyectos por estrato: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de vo's
        return respuesta;

    }
        
}
