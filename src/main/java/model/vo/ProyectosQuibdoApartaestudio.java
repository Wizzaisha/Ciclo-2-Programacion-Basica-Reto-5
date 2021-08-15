package model.vo;

public class ProyectosQuibdoApartaestudio {
    //su codigo
    private Integer idProyecto;
    private String constructora;
    private Float porcentajeCuotaInicial;
    private String acabados;

    public ProyectosQuibdoApartaestudio() {
    }

    public ProyectosQuibdoApartaestudio(Integer idProyecto, String constructora, Float porcentajeCuotaInicial, String acabados) {
        this.idProyecto = idProyecto;
        this.constructora = constructora;
        this.porcentajeCuotaInicial = porcentajeCuotaInicial;
        this.acabados = acabados;
    }

    
    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public Float getPorcentajeCuotaInicial() {
        return porcentajeCuotaInicial;
    }

    public void setPorcentajeCuotaInicial(Float porcentajeCuotaInicial) {
        this.porcentajeCuotaInicial = porcentajeCuotaInicial;
    }

    public String getAcabados() {
        return acabados;
    }

    public void setAcabados(String acabados) {
        this.acabados = acabados;
    } 
}
