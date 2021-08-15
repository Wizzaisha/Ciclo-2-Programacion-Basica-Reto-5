package view;

import controller.ControladorRequerimientosReto4;
import model.vo.ProyectosPorEstrato;
import model.vo.ProyectosPorTipo;
import model.vo.ProyectosQuibdoApartaestudio;

import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;



import java.sql.SQLException;
import java.util.ArrayList;

public class VistaRequerimientos extends JFrame{
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    private JPanel panel;
    private static JTextArea aTexto;

    public VistaRequerimientos(){
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 150, 800, 500);
        panel = new JPanel();
        setContentPane(panel);
        panel.setOpaque(true);
        panel.setBackground(Color.white);
        
        panel.setLayout(null);
        
        
        JLabel titulo = new JLabel("Ciclo 2 - Programación Básica");
        titulo.setBounds(250,10,1000,20);
        panel.add(titulo);

        JLabel etiqueta = new JLabel("Reto 5 - Consulta de requerimientos");
        etiqueta.setBounds(235,35,1000,20);
        panel.add(etiqueta);

        JLabel autor = new JLabel("Autor: Ever Ramirez Mahecha.");
        autor.setBounds(30,395,1000,30);
        panel.add(autor);

        JLabel fecha = new JLabel("Fecha:15/08/2021.");
        fecha.setBounds(30,420,1000,30);
        panel.add(fecha);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30,70,570,320);
        panel.add(scrollPane);

        aTexto = new JTextArea();
        scrollPane.setViewportView(aTexto);

        JButton bconsulta1 = new JButton("Consulta 1");
        bconsulta1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                consultarProyectosPorEstratos();
            }
        });
        bconsulta1.setBounds(620,70,140,80);
        
        
        
        panel.add(bconsulta1);

        JButton bconsulta2 = new JButton("Consulta 2");
        bconsulta2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                consultarProyectosPorTipos();
            }
        });
        bconsulta2.setBounds(620,150,140,80);
        panel.add(bconsulta2);

        JButton bconsulta3 = new JButton("Consulta 3");
        bconsulta3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                consultarProyectosQuibdoApartaestudios();
            }
        });
        bconsulta3.setBounds(620,230,140,80);
        panel.add(bconsulta3);

        JButton limpiar = new JButton("Limpiar");
        limpiar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                aTexto.setText("");
            }
        });
        limpiar.setBounds(620,310,140,80);
        panel.add(limpiar);

    }



    public static void consultarProyectosPorEstratos(){
    
        try{
            ArrayList<ProyectosPorEstrato> rankingProyectosPorEstratos = controlador.consultarProyectosPorEstratos();
            String salida = "*** Proyectos por Estrato ***\n\n  Id_Tipo\tCodigoTipo\tAreaMaxima\tEstrato\n\n";

            for (ProyectosPorEstrato proyectosPorEstrato: rankingProyectosPorEstratos){
                    
                    salida += "  ";
                    salida += proyectosPorEstrato.getIdTipo();
                    salida += "\t";
                    salida += proyectosPorEstrato.getCodigoTipo();
                    salida += "\t";
                    salida += proyectosPorEstrato.getAreaMaxima();
                    salida += "\t";
                    salida += proyectosPorEstrato.getEstrato();
                    salida += "\n";
            }
            aTexto.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public static void consultarProyectosPorTipos(){     


        try{
            
            ArrayList<ProyectosPorTipo> rankingProyectosPorTipo = controlador.consultarProyectosPorTipos();
            String salida = "*** Proyectos por Tipo ***\n\n  Id_Proyecto\tConstructora\t\tCiudad\tEstrato\n\n";

            for (ProyectosPorTipo proyectosPorTipo: rankingProyectosPorTipo){

                salida += "  ";
                salida += proyectosPorTipo.getIdProyecto();
                salida += "\t";
                salida += proyectosPorTipo.getConstructora();
                if(proyectosPorTipo.getConstructora().length()<=11){
                    salida += "\t\t";
                }else{
                    salida += "\t";
                }
                salida += proyectosPorTipo.getCiudad();
                salida += "\t";
                salida += proyectosPorTipo.getEstrato();
                salida += "\n";
            }

            aTexto.setText(salida);

        }catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void consultarProyectosQuibdoApartaestudios(){

        try{
              // su codigo
            ArrayList<ProyectosQuibdoApartaestudio> rankingProyectosQuibdoApartaestudios = controlador.consultarProyectosQuibdoApartaestudios();
            String salida = "*** Proyectos de Tipo Apartaestudio en Quibdo ***\n\n  Id_Proyecto\tConstructora\t\tPorcentaje Cuota Inicial\tAcabados\n\n";

            for (ProyectosQuibdoApartaestudio proyectosQuibdoApartaestudio: rankingProyectosQuibdoApartaestudios){
                
                salida += "  ";
                salida += proyectosQuibdoApartaestudio.getIdProyecto();
                salida += "\t";
                salida += proyectosQuibdoApartaestudio.getConstructora();
                salida += "\t";
                salida += proyectosQuibdoApartaestudio.getPorcentajeCuotaInicial();
                salida += "\t";
                salida += "\t";
                salida += proyectosQuibdoApartaestudio.getAcabados();
                salida += "\n";
                    
            }    
            aTexto.setText(salida);

        }catch(SQLException e){
            System.err.println(e);
        }
    }

}
