package org.example.DAO;

import org.example.Util.HibernateUtil;
import org.example.entities.Familia;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FamiliaDAOImpl implements IFamiliaDAO {
    /**
     * Guarda una familia en la base de datos.
     *
     * @param familia la familia a guardar.
     */
    @Override
    public void save(Familia familia) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(familia);
        transaction.commit();
        session.close();
    }

    /**
     * Busca una familia por su nombre.
     *
     * @param nombre el nombre de la familia.
     * @return la familia encontrada o null si no existe.
     */
    @Override
    public Familia findById(String nombre) {
        return HibernateUtil.getSessionFactory().openSession().find(Familia.class, nombre);
    }

    /**
     * Obtiene todas las familias registradas.
     *
     * @return una lista con todas las familias.
     */
    @Override
    public List<Familia> findAll() {
        return null;
    }

    /**
     * Actualiza los datos de una familia existente.
     *
     * @param familia la familia a actualizar.
     */
    @Override
    public void update(Familia familia) {

    }

    /**
     * Elimina una familia de la base de datos.
     *
     * @param familia la familia a eliminar.
     */
    @Override
    public void delete(Familia familia) {

    }
}
