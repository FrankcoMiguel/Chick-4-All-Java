package Service;

import Model.Customer;
import Model.Order;
import Model.OrderDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

interface IOrderDetailService {

    boolean NewOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> ReadOrderDetails(int Id);

    boolean UpdateOrderDetail(int Id, OrderDetail orderDetail);

    boolean RemoveOrderDetail(int Id);

}

public class OrderDetailService implements IOrderDetailService {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Dev");

    @Override
    public boolean NewOrderDetail(OrderDetail orderDetail) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(orderDetail);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in NewOrderDetail Transaction");

        } finally {

            entityManager.close();

        }

        return false;

    }

    @Override
    public List<OrderDetail> ReadOrderDetails(int Id) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<OrderDetail> details = null;

        try {

            entityManager.getTransaction().begin();
            details = entityManager.createNamedQuery("Order.findAllDetails").getResultList();
            entityManager.getTransaction().commit();

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in ReadOrderDetails Transaction");

        } finally {

            entityManager.close();

        }

        return details;
    }

    @Override
    public boolean UpdateOrderDetail(int Id, OrderDetail orderDetail) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            OrderDetail oldDetail = entityManager.find(OrderDetail.class, Id);
            entityManager.getTransaction().begin();
            oldDetail.setCost(orderDetail.getCost());
            oldDetail.setItem(orderDetail.getItem());
            oldDetail.setOrder(orderDetail.getOrder());
            oldDetail.setQuantity(orderDetail.getQuantity());
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in UpdateDetail Transaction");

        } finally {

            entityManager.close();

        }

        return false;
    }

    @Override
    public boolean RemoveOrderDetail(int Id) {

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
