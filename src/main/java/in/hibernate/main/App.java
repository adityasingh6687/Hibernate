package in.hibernate.main;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.hibernate.main.entity.Answer;
import in.hibernate.main.entity.Question;

public class App {
	public static void main(String[] args) {

//		Question q1 = new Question();
//		q1.setQuestion("What is Hibernate ?");
//
//		Answer a1 = new Answer();
//		a1.setAnswer("hibernate is a java framework.");
//		a1.setQuestion(q1);
//
//		Answer a2 = new Answer();
//		a2.setAnswer("it is an ORM tools.");
//		a2.setQuestion(q1);
//
//		List<Answer> list = new ArrayList<>();
//		list.add(a1);
//		list.add(a2);
//		q1.setAnswer(list);

		SessionFactory factory = new Configuration().configure("/in/hibernate/main/cfg/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = factory.openSession();
		
//		String query = "from question";
//		Query<Question> query2 = session.createQuery(query);
		NativeQuery<Question> nativeQuery = session.createNativeQuery("select * from question");
		
		List<Question> data =  nativeQuery.getResultList();
		for(Question item : data)
		{
			System.out.println(item.getQuestion());
		}
		
		
//		Transaction trans = session.beginTransaction();
//
//		session.save(q1);
//		session.save(a1);
//		session.save(a2);
//		trans.commit();
		session.close();

	}
}

//		Configuration cfg = new Configuration().configure("/in/hibernate/main/cfg/hibernate.cfg.xml");
//
//		SessionFactory factory = cfg.buildSessionFactory();
//
//		Session session = factory.openSession();
//
//		Transaction trans = session.beginTransaction();
//
//		Student std = new Student();
//		std.setName("Aditya Singh");
//		std.setEmail("adityasingh@gmail.com");
//		std.setCourse("MCA");
//		
//		Address add = new Address();
//		add.setCity("Meerut");
//		add.setArea("Sankar Nagar Phase-2");
//		add.setPin("250103");
//		std.setAddress(add);
//		add.setStudent(std);
//		
//		Student student = session.get(Student.class,1);
//		Student student = session.load(Student.class, 1);
//		System.out.println(student.toString());
//		
//		session.save(std);
//		session.save(add);
//		trans.commit();
//		session.close();
