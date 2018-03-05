package org.sample.serverless.aws.rds;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserInsertHandler implements RequestHandler<Request, String> {

	@Override
	public String handleRequest(Request request, Context context) {
		System.out.println("Vaibhav Pandey: " + request.getId());
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			User user = new User();
			user.setName(request.getName());
			session.save(user);
			session.getTransaction().commit();
		}

		return String.format("Added %s %s.", request.getId(), request.getName());
	}
}
