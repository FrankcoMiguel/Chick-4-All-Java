package Service;


import Model.Item;
import Model.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

interface IItemService{

    boolean AddItem(Item item);

    List<Item> ReadItems();

    Item ReadItem(int Id);

    boolean UpdateItem(int Id, Item item);

    boolean RemoveItem(int Id);


}

public class ItemService implements IItemService {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Dev");

    @Override
    public boolean AddItem(Item item) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(item);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in AddItem Transaction");

        } finally {

            entityManager.close();

        }

        return false;
    }

    @Override
    public List<Item> ReadItems() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Item> items = null;

        try {

            entityManager.getTransaction().begin();
            items = entityManager.createNamedQuery("Users.findAll").getResultList();
            entityManager.getTransaction().commit();

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in ReadItems Transaction");

        } finally {

            entityManager.close();

        }

        return items;
    }

    @Override
    public Item ReadItem(int Id) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        Item item = null;

        try {

            entityManager.getTransaction().begin();
            item = entityManager.find(Item.class,Id);
            entityManager.getTransaction().commit();

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in ReadItem Transaction");

        } finally {

            entityManager.close();

        }

        return item;

    }

    @Override
    public boolean UpdateItem(int Id, Item item) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            Item oldItem = entityManager.find(Item.class, Id);
            entityManager.getTransaction().begin();
            oldItem.setName(item.getName());
            oldItem.setAvailability(item.isAvailability());
            oldItem.setCostPerUnit(item.getCostPerUnit());
            oldItem.setTax(item.getTax());
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in UpdateItem Transaction");

        } finally {

            entityManager.close();

        }

        return false;
    }

    @Override
    public boolean RemoveItem(int Id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            Item item = entityManager.find(Item.class, Id);
            entityManager.getTransaction().begin();
            entityManager.remove(item);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in RemoveItem Transaction");

        } finally {

            entityManager.close();

        }

        return false;
    }

}
