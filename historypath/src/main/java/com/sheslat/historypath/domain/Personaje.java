package com.sheslat.historypath.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table (name="ST_PERSONAJE")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "EDAD", nullable = false)
    private Long edad;

    @ManyToOne
    @JoinColumn(name = "RAZA_ID", nullable = false)
    private Raza raza;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "LUGAR_ID", nullable = false)
    private Lugar lugarOrigen;

}
