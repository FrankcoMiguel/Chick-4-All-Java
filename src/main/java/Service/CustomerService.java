package Service;


import Model.Customer;
import Model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

interface ICustomerService{


    boolean AddCustomer(Customer customer); //CREATE

    List<Customer> ReadCustomers(); //SELECT ALL

    Customer ReadCustomer(int Id); //SELECT by Id

    boolean UpdateCustomer(int Id, Customer customer); //UPDATE

    boolean RemoveCustomer(int Id); //REMOVE

}


public class CustomerService implements ICustomerService {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Dev");

    @Override
    public boolean AddCustomer(Customer customer) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in AddCustomer Transaction");

        } finally {

            entityManager.close();

        }

        return false;
    }

    @Override
    public List<Customer> ReadCustomers() {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Customer> customers = null;

        try {

            entityManager.getTransaction().begin();
            customers = entityManager.createNamedQuery("Customers.findAll").getResultList();
            entityManager.getTransaction().commit();

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in ReadCustomers Transaction");

        } finally {

            entityManager.close();

        }

        return customers;
    }

    @Override
    public Customer ReadCustomer(int Id) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        Customer customer = null;

        try {

            entityManager.getTransaction().begin();
            customer = entityManager.find(Customer.class,Id);
            entityManager.getTransaction().commit();

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in ReadUser Transaction");

        } finally {

            entityManager.close();

        }

        return customer;
    }

    @Override
    public boolean UpdateCustomer(int Id, Customer customer) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            Customer oldCustomer = entityManager.find(Customer.class, Id);
            entityManager.getTransaction().begin();
            oldCustomer.setName(customer.getName());
            oldCustomer.setAddress(customer.getAddress());
            oldCustomer.setBirthDate(customer.getBirthDate());
            oldCustomer.setJoinDate(customer.getJoinDate());
            oldCustomer.setPlatform(customer.getPlatform());
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in UpdateCustomer Transaction");

        } finally {

            entityManager.close();

        }

        return false;
    }

    @Override
    public boolean RemoveCustomer(int Id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            Customer customer = entityManager.find(Customer.class, Id);
            entityManager.getTransaction().begin();
            entityManager.remove(customer);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in RemoveCustomer Transaction");

        } finally {

            entityManager.close();

        }

        return false;
    }
}
