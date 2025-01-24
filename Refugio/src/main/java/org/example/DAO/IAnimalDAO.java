package org.example.DAO;

import org.example.entities.Animal;

import java.util.List;

/**
 * Interfaz para operaciones CRUD de la entidad Animal.
 */
public interface IAnimalDAO {

    /**
     * Guarda un animal en la base de datos.
     *
     * @param animal el animal a guardar.
     */
    void save(Animal animal);

    /**
     * Busca un animal por su nombre.
     *
     * @param nombre el nombre del animal.
     * @return el animal encontrado o null si no existe.
     */
    Animal findById(String nombre);

    /**
     * Busca animales por especie.
     *
     * @param especie la especie a buscar.
     * @return una lista de animales de esa especie.
     */
    List<Animal> findByEspecie(String especie);

    /**
     * Obtiene todos los animales.
     *
     * @return una lista con todos los animales.
     */
    List<Animal> findAll();

    /**
     * Actualiza un animal existente.
     *
     * @param animal el animal a actualizar.
     */
    void update(Animal animal);

    /**
     * Elimina un animal de la base de datos.
     *
     * @param animal el animal a eliminar.
     */
    void delete(Animal animal);
}
