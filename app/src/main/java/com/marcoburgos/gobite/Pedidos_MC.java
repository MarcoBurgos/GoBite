package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 10/05/17.
 */

public class Pedidos_MC {
    private int imageRestaurante;
    private String idPedido;
    private String statusPedido;
    private String programacionPedido;

    public Pedidos_MC (int imageRestaurante, String idPedido, String statusPedido, String programacionPedido) {
        this.imageRestaurante = imageRestaurante;
        this.idPedido = idPedido;
        this.statusPedido = statusPedido;
        this.programacionPedido = programacionPedido;
    }

    public int getImageRestaurante () {return imageRestaurante;}
    public String getIdPedido() {return  idPedido;}
    public String getStatusPedido() {return statusPedido;}
    public String getProgramacionPedido() {return programacionPedido;}
}
