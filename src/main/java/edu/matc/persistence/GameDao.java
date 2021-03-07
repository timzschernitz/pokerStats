package edu.matc.persistence;


import edu.matc.entity.Game;
import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * This class performs database interactions related to Game objects.
 *
 * @author tzschernitz
 */
public class GameDao {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets authors by last name
     */
    public List<Game> getGamesByUserName(User user) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> query = builder.createQuery(Game.class);

        Root<Game> root = query.from(Game.class);

        Expression<String> propertyPath = root.get("user_id");

        query.where(builder.like(propertyPath, "%" + user + "%"));

        List<Game> games = session.createQuery(query).getResultList();

        session.close();
        return games;

    }



    /**
     * insert Game
     * @param Game  Game to be inserted
     */
//    public int insert(Game Game) {
//        int id = 0;
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        id = (int)session.save(Game);
//        transaction.commit();
//        session.close();
//        return id;
//    }

    /**
     * Delete a Game
     * @param Game Game to be deleted
     */
//    public void delete(Game Game) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.delete(Game);
//        transaction.commit();
//        session.close();
//    }

}
