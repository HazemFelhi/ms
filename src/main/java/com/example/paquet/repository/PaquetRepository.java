package com.example.paquet.repository;

import com.example.paquet.model.Paquet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
public interface PaquetRepository extends JpaRepository<Paquet, Long> {

    void delete(Optional<Paquet> paquet);
}
