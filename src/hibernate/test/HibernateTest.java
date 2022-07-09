package hibernate.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateTest {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();

        Set<Book> books = new HashSet<>();
        books.add(new Book("Theoretical physics-"+ Math.random()));
        books.add(new Book("Maths-"+ Math.random()));
        books.add(new Book("economics-"+ Math.random()));
        
        Student st1 = new Student("Name-"+ Math.random());
        st1.setBooks(books);

        Transaction tx = session.beginTransaction();
        //session.save(st1);
        tx.commit();
        
        //Student studGId = session.get(Student.class, st1.getId());
        
        //System.out.println(">> [studGId] "+ studGId.getFirstName());
        
        Query q1 = session.createQuery("FROM Student"); // Student is class name

        q1.setFirstResult(0);
        q1.setMaxResults(25);
        
        List<Student> resStudents = q1.getResultList();
        
        for(Student stud : resStudents) {
            System.out.println(">> "+ stud.getFirstName());
            System.out.println(">> "+ stud.getBooks().size());
        }

        session.close();
        HibernateUtil.shutdown();
    }
}
