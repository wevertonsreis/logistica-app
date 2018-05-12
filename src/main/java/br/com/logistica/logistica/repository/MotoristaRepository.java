package br.com.logistica.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.logistica.logistica.entity.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

}
