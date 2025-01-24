package org.example.DAO;

import org.example.entities.Familia;

import java.util.List;

/**
 * Interfaz para operaciones CRUD de la entidad Familia.
 */
public interface IFamiliaDAO {

    /**
     * Guarda una familia en la base de datos.
     *
     * @param familia la familia a guardar.
     */
    void save(Familia familia);

    /**
     * Busca una familia por su nombre.
     *
     * @param nombre el nombre de la familia.
     * @return la familia encontrada o null si no existe.
     */
    Familia findById(String nombre);

    /**
     * Obtiene todas las familias registradas.
     *
     * @return una lista con todas las familias.
     */
    List<Familia> findAll();

    /**
     * Actualiza los datos de una familia existente.
     *
     * @param familia la familia a actualizar.
     */
    void update(Familia familia);

    /**
     * Elimina una familia de la base de datos.
     *
     * @param familia la familia a eliminar.
     */
    void delete(Familia familia);
}

