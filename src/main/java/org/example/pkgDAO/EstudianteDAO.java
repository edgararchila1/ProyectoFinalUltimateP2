package org.example.pkgDAO;

import org.example.pkgConexion.Conexion;
import org.example.pkgDTO.EstudianteDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EstudianteDAO {
    private Conexion conexion;

    public EstudianteDAO() {
        conexion = new Conexion();
    }

    public EstudianteDTO obtenerEstudiante(int idEstudiante) {
        EstudianteDTO estudiante = null;
        String query = "SELECT * FROM Estudiantes WHERE id_estudiante = ?";

        try (Connection conn = conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idEstudiante);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                estudiante = new EstudianteDTO();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiante;
    }

    // Métodos similares para insertar, actualizar y eliminar estudiantes...

    public void guardarEstudiante(EstudianteDTO estudiante) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(estudiante);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

