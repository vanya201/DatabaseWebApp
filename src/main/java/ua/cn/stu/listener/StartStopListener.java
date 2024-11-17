package ua.cn.stu.listener;
import stu.cn.ua.dao.HibernateDAOFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartStopListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0)
    {
        HibernateDAOFactory factory = HibernateDAOFactory.getInstance();
        ServletContext context = arg0.getServletContext();
        context.setAttribute("productDAO", factory.getProductDAO());
        context.setAttribute("sellerDAO", factory.getSellerDAO());
    }
}