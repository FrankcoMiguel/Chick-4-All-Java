package Service;


import Model.User;

import javax.persistence.*;
import java.util.List;

interface IUserService {

    //Create Service
    boolean AddUser(User user);

    //Read Services
    List<User> ReadUsers();
    User ReadUser(Long Id);

    //Update Service
    boolean UpdateUser(long Id, User user);

    //Remove Service
    boolean RemoveUser(long Id);

    //Login Service
    boolean LogIn(String Username, String Password);

}

public class UserService implements IUserService{

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Dev");

    @Override
    public boolean AddUser(User user) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in AddUser Transaction");

        } finally {

            entityManager.close();

        }

        return false;

    }

    @Override
    public List<User> ReadUsers() {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<User> users = null;

        try {

            entityManager.getTransaction().begin();
            users = entityManager.createNamedQuery("Users.findAll").getResultList();
            entityManager.getTransaction().commit();

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in ReadUsers Transaction");

        } finally {

            entityManager.close();

        }

        return users;

    }

    @Override
    public User ReadUser(Long Id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        User user = null;

        try {

            entityManager.getTransaction().begin();
            user = entityManager.find(User.class,Id);
            entityManager.getTransaction().commit();

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in ReadUser Transaction");

        } finally {

            entityManager.close();

        }

        return user;
    }

    @Override
    public boolean UpdateUser(long Id, User user) {

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            User oldUser = entityManager.find(User.class, Id);
            entityManager.getTransaction().begin();
            oldUser.setPhone(user.getPhone());
            oldUser.setUsername(user.getUsername());
            oldUser.setPassword(user.getPassword());
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in UpdateUser Transaction");

        } finally {

            entityManager.close();

        }

        return false;
    }

    @Override
    public boolean RemoveUser(long Id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        try {

            User oldUser = entityManager.find(User.class, Id);
            entityManager.getTransaction().begin();
            entityManager.remove(oldUser);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e){

            if (entityManager.getTransaction() != null){

                entityManager.getTransaction().rollback();

            }

            System.out.println("Error in RemoveUser Transaction");

        } finally {

            entityManager.close();

        }

        return false;
    }

    @Override
    public boolean LogIn(String Username, String Password) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        User user = null;

        try {

            entityManager.getTransaction().begin();
            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.Username = :username AND u.Password = :pass", User.class);
            query.setParameter("username",Username);
            query.setParameter("pass",Password);
            entityManager.getTransaction().commit();
            user = query.getSingleResult();

        } catch (Exception e){

            System.out.println("User not found!");
            return false;

        } finally {

            entityManager.close();

        }

        return user != null;
    }

}
