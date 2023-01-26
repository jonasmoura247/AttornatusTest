package br.com.test.person.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "nome", nullable = false)
    private String nome;
    
    @Column (name = "logradouro")
    private String logradouro;
    
    @Column (name = "bairro")
    private String bairro;
    
    @Column (name = "cidade")
    private String cidade;

}
