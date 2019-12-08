package Service;


import Model.Order;
import Model.OrderDetail;
import Model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

interface IOrderService{

    boolean AddOrder(Order order);

    List<Order> ReadOrders();

    Order ReadOrder(int Id);

    boolean UpdateOrder(int Id, Order order);

    boolean RemoveOrder(int Id);


}

public class OrderService implements IOrderService {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Dev");

    @Override
    public boolean AddOrder(Order order) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(order);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in AddOrder Transaction");

        } finally {

            entityManager.close();

        }

        return false;

    }

    @Override
    public List<Order> ReadOrders() {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Order> orders = null;

        try {

            entityManager.getTransaction().begin();
            orders = entityManager.createNamedQuery("Users.findAll").getResultList();
            entityManager.getTransaction().commit();

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in ReadOrders Transaction");

        } finally {

            entityManager.close();

        }

        return orders;

    }

    @Override
    public Order ReadOrder(int Id) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        Order order = null;

        try {

            entityManager.getTransaction().begin();
            order = entityManager.find(Order.class,Id);
            entityManager.getTransaction().commit();

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in ReadOrder Transaction");

        } finally {

            entityManager.close();

        }

        return order;

    }

    @Override
    public boolean UpdateOrder(int Id, Order order) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            Order oldOrder = entityManager.find(Order.class, Id);
            entityManager.getTransaction().begin();
            oldOrder.setCustomer(order.getCustomer());
            oldOrder.setAltAddress(order.getAltAddress());
            oldOrder.setDate(order.getDate());
            oldOrder.setSubTotal(order.getSubTotal());
            oldOrder.setTotal(order.getTotal());
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in UpdateOrder Transaction");

        } finally {

            entityManager.close();

        }

        return false;
    }

    @Override
    public boolean RemoveOrder(int Id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            Order order = entityManager.find(Order.class, Id);
            entityManager.getTransaction().begin();
            entityManager.remove(order);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in RemoveOrder Transaction");

        } finally {

            entityManager.close();

        }

        return false;
    }

}
