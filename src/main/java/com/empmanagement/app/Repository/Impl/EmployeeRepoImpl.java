package com.empmanagement.app.Repository.Impl;

import com.empmanagement.app.Exeption.EmployeeException;
import com.empmanagement.app.Repository.Interfaces.EmployeeRepo;
import com.empmanagement.app.model.Employee;
import org.hibernate.Transaction;
import org.hibernate.Session;
import com.empmanagement.app.utils.HibernateUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class EmployeeRepoImpl implements EmployeeRepo {

    @Override
    public Boolean add(Employee employee) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new EmployeeException(e.getMessage());
        }
    }

    @Override
    public Optional<Employee> findById(UUID id) throws EmployeeException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.of(session.get(Employee.class, id));
        }catch (Exception e){
            throw new EmployeeException(e.getMessage());
        }
    }

    @Override
    public List<Employee> getAll() throws EmployeeException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Employee", Employee.class).list();
        } catch (Exception e) {
            throw new EmployeeException(e.getMessage());
        }
    }

    @Override
    public Boolean update(Employee employee) throws EmployeeException {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new EmployeeException(e.getMessage());
        }
    }

    @Override
    public Boolean delete(Employee employee) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
            return true;
        }catch (Exception e){
            if (transaction != null) transaction.rollback();
            throw new EmployeeException(e.getMessage());
        }
    }

    @Override
    public List<Employee> search(String query) throws EmployeeException {
        String hql = "FROM Employee WHERE lower(name) LIKE :query OR lower(email) LIKE :query OR lower(phone) LIKE :query";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Employee.class)
                    .setParameter("query", "%" + query.toLowerCase() + "%")
                    .list();
        } catch (Exception e) {
            throw new EmployeeException(e.getMessage());
        }
    }

}
