package hibernate;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.UserBean;


public class Userinfo  {
	
	public static void saveUser(UserBean user) {
		   Session session = HibernateSessionFactory.getSessionFactory().openSession();
		   session.beginTransaction();

		   session.save(user);

		   session.getTransaction().commit();
		  }
	
	public static ArrayList<?> getUser() {
		   Session session = HibernateSessionFactory.getSessionFactory().openSession();
		   session.beginTransaction();

		   List<UserBean> list = (List<UserBean>)session.createQuery("from user").list();
		   ArrayList<String> list2= new ArrayList<String>();
		   
		   
		   for(int i=0;i<list.size();i++) {
			   int tmp = list.get(i).getId();
			   StringBuilder sBuilder = new StringBuilder();
			   sBuilder.append(tmp);
			   list2.add(sBuilder.toString());
			   list2.add(list.get(i).getUsername());
			   list2.add(list.get(i).getPassword());
		   }
		   
		   session.getTransaction().commit();
		   return list2;
		  }

}
