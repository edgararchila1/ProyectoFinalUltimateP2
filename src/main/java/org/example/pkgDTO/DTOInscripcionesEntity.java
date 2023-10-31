package org.example.pkgDTO;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "inscripciones", schema = "public", catalog = "ProyectoFinalP2")
public class DTOInscripcionesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_inscripcion")
    private int idInscripcion;
    @Basic
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
    @Basic
    @Column(name = "id_curso")
    private Integer idCurso;
    @Basic
    @Column(name = "fecha_inscripcion")
    private Date fechaInscripcion;

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
