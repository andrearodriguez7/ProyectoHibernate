package org.example.DAO;

import org.example.Util.HibernateUtil;
import org.example.entities.Animal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AnimalDAOImpl implements IAnimalDAO {

    // Método para guardar un animal en la base de datos (aún no implementado)
    @Override
    public void save(Animal animal) {
        // Implementación para guardar un animal en la base de datos
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction=session.beginTransaction();
            session.persist(animal);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Método para encontrar un animal por su nombre (aún no implementado)
    @Override
    public Animal findById(String nombre) {
        // Implementación para encontrar un animal por su nombre
        return null;
    }

    /**
     * Busca animales por especie.
     *
     * @param especie la especie a buscar.
     * @return una lista de animales de esa especie.
     */
    @Override
    public List<Animal> findByEspecie(String especie) {
        // Obtener la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Realizar la consulta para encontrar animales por especie
        String hql = "FROM Animal WHERE especie = :especie";  // HQL (Hibernate Query Language)
        Query<Animal> query = session.createQuery(hql, Animal.class);
        query.setParameter("especie", especie);  // Establecer el parámetro especie

        // Ejecutar la consulta y obtener la lista de animales
        List<Animal> animales = query.list();

        // Cerrar la sesión de Hibernate
        session.close();

        // Devolver la lista de animales (si no hay, se devuelve una lista vacía)
        return animales != null ? animales : new ArrayList<>();
    }

    // Método para obtener todos los animales (aún no implementado)
    @Override
    public List<Animal> findAll() {
        // Implementación para obtener todos los animales
        return null;
    }

    // Método para actualizar un animal (aún no implementado)
    @Override
    public void update(Animal animal) {
        // Implementación para actualizar un animal
    }

    // Método para eliminar un animal (aún no implementado)
    @Override
    public void delete(Animal animal) {
        // Implementación para eliminar un animal
    }
}
