package com.mballem.curso.boot.util;

import java.util.List;

public class PaginacaoUtil<T> {
    private int pagina;
    private int tamanho;
    private String direcao;
    private List<T> registros;
    private Long totalDePaginas;
    


    public PaginacaoUtil(int pagina, int tamanho, String direcao, List<T> registros, Long totalDePaginas) {
        this.pagina = pagina;
        this.tamanho = tamanho;
        this.direcao = direcao;
        this.registros = registros;
        this.totalDePaginas = totalDePaginas;
    }

    public int getPagina() {
        return pagina;
    }
    public int getTamanho() {
        return tamanho;
    }

    public String getDirecao() {
        return direcao;
    }

    public List<T> getRegistros() {
        return registros;
    }
    public Long getTotalDePaginas() {
        return totalDePaginas;
    }   
}
