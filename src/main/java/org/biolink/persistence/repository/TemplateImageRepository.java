package org.biolink.persistence.repository;

import org.biolink.persistence.model.Person;
import org.biolink.persistence.model.TemplateImage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class TemplateImageRepository extends org.biolink.persistence.repository.common.AbstractRepo {

    public TemplateImage findOne(Long id) {
        return (TemplateImage) sessionFactory.getCurrentSession().createQuery("from template_image p where id = :id").setParameter("id", id ).uniqueResult();
    }

    public TemplateImage findByTemplate(byte[] templateImage) {
        return (TemplateImage) sessionFactory.getCurrentSession().createQuery("from template_image p where image = :templateImage").setParameter("templateImage", templateImage ).uniqueResult();
    }

    public long create(TemplateImage entity) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
        return entity.getId();
    }

    public void update(TemplateImage entity) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
    }

    public void deleteById(long id){
        TemplateImage t = findOne(id);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(t);
        tx.commit();
        session.close();
    }

    public void deleteByTemplateId(byte[] templateImage){
        TemplateImage t = findByTemplate(templateImage);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(t);
        tx.commit();
        session.close();
    }
}
