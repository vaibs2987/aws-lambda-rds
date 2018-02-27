package org.sample.serverless.aws.rds;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetUserHandler implements RequestHandler<Request, User> {

	@Override
	public User handleRequest(Request request, Context arg1) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		User user = null;
		try (Session session = sessionFactory.openSession()) {
			user = (User) session.get(User.class, request.getId());
		} catch (Exception e) {
			System.out.println("Exception occurs while getting user");
			e.printStackTrace();
		}
		return user;
	}

}
