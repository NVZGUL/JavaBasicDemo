package com.povazhnuk.contactmgr;

import com.povazhnuk.contactmgr.model.Contact;
import com.povazhnuk.contactmgr.model.Contact.ConactBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Application {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        // Create a StandardServiceRegistry
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        Contact contact = new ConactBuilder("Slava", "Povazhnuk")
                .withEmail("h3rmess@gmail.com")
                .withPhone(79627128578L)
                .build();
        int id = save(contact);

        // Display a list of contacts before the update
        System.out.printf("%n%nBefore Update%n%n");
        fetchAllContacts().stream().forEach(System.out::println);

        // Get the persisted contact
        Contact c = findContactById(id);

        // Update the contact
        c.setFirstName("Red");

        // Persist the changes
        System.out.printf("%n%nUpdating..%n%n");
        update(c);
        System.out.printf("%n%nUpdate Complete!%n%n");
        System.out.printf("%n%nAfter update%n%n");
        fetchAllContacts().stream().forEach(System.out::println);
        System.out.printf("%n%nDeleting..%n%n");
        delete(c);
        System.out.printf("%n%nDelete Complete!%n%n");
        System.out.printf("%n%nAfter delete%n%n");
        fetchAllContacts().stream().forEach(System.out::println);
    }

    public static Contact findContactById(int id) {
        // Open a session
        Session session = sessionFactory.openSession();

        //

        Contact contact = session.get(Contact.class, id);

        // Close the session
        session.close();

        return contact;
    }

    public static void update (Contact contact) {
        // Open a session
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.update(contact);

        session.getTransaction().commit();

        session.close();
    }

    public static void delete(Contact contact) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.delete(contact);

        session.getTransaction().commit();

        session.close();
    }

    @SuppressWarnings("unchecked")
    private static List<Contact> fetchAllContacts() {
        // Open a session
        Session session = sessionFactory.openSession();

        // Create Criteria
        Criteria criteria = session.createCriteria(Contact.class);

        // Get a list of Contact object according to the Criteria object
        List<Contact> contacts = criteria.list();

        // Close the session
        session.close();

        return contacts;
    }

    public static int save(Contact contact){
        // Open Session
        Session session = sessionFactory.openSession();

        // Begin transaction
        session.beginTransaction();

        // Use the session to save the contact
        int id = (int)session.save(contact);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();

        return id;
    }
}
