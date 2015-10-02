package org.biolink.persistence.repository;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.biolink.persistence.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository extends org.biolink.persistence.repository.common.AbstractRepo {

    /**
     * Найти посетителя по id
     * @param id - идентификатор юзера
     * @return посетителя
     */
    public Person findOne(Long id) {
        return (Person) sessionFactory.getCurrentSession().createQuery("from person p where id = :id").setParameter("id", id ).uniqueResult();
    }

    public Person findByCard(String cardNumber) {
        return (Person) sessionFactory.getCurrentSession().createQuery("from person p where card_number = :cardNumber").setParameter("cardNumber", cardNumber).uniqueResult();
    }

    public Person findByKeeperId(String idKeeper) {
        return (Person) sessionFactory.getCurrentSession().createQuery("from person p where id_keeper = :idKeeper").setParameter("idKeeper", idKeeper ).uniqueResult();
    }

    /**
     * получить всех зарегистрированных пользователей
     *
     * @return
     */
    public List<Person> findAll() {
        return (List<Person>) sessionFactory.getCurrentSession().createQuery("from person p").list();
    }

    /**
     * создать нового посетителя
     * @param entity
     * @return
     */
    public long create(Person entity) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
        return entity.getId();
    }

    public void update(Person entity) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
    }

}