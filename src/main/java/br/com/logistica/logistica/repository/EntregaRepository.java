package br.com.logistica.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.logistica.logistica.entity.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}