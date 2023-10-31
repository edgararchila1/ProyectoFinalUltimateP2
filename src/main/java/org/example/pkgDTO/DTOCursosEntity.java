package org.example.pkgDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos", schema = "public", catalog = "ProyectoFinalP2")
public class DTOCursosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_curso")
    private int idCurso;
    @Basic
    @Column(name = "nombre_curso")
    private String nombreCurso;
    @Basic
    @Column(name = "profesor")
    private String profesor;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}
