package com.mballem.curso.boot.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.mballem.curso.boot.domain.Cargo;
import com.mballem.curso.boot.util.PaginacaoUtil;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {
    public PaginacaoUtil<Cargo> buscaPaginada(int pagina, String direcao) {
        int tamanho = 5;
        int inicio = (pagina - 1) * tamanho; 

        List<Cargo> cargos = getEntityManager()
            .createQuery("SELECT c FROM Cargo c ORDER BY c.nome " + direcao, Cargo.class)
            .setFirstResult(inicio)
            .setMaxResults(tamanho)
            .getResultList();

        Long totalRegistros = count();
        Long totalPaginas = (totalRegistros + (tamanho - 1))  / tamanho;

        return new PaginacaoUtil<Cargo>(pagina, tamanho, direcao, cargos, totalPaginas);
    }

    public Long count() {
        return getEntityManager()
            .createQuery("SELECT count(*) FROM Cargo", Long.class).getSingleResult();
    }
}
