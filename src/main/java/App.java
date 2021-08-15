import view.VistaRequerimientos;
import java.awt.EventQueue;

public class App { 
    public static void main( String[] args ){        

        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    VistaRequerimientos frame = new VistaRequerimientos();
                    frame.setVisible(true);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }


        });

        /*
        //Casos de prueba 

        //Requerimiento 1 - Reto3
        VistaRequerimientos.consultarProyectosPorEstratos();
        System.out.println();

         //Requerimiento 2 - Reto3
         VistaRequerimientos.consultarProyectosPorTipos();
         System.out.println();

        //Requerimiento 5 - Reto3
        VistaRequerimientos.consultarProyectosQuibdoApartaestudios();
        System.out.println();
        */
    }

}
