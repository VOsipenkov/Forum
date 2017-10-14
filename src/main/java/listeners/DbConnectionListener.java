package listeners;

import utils.DBWorker;
import utils.DBWorkerImpl;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DbConnectionListener implements ServletContextListener {
    private DBWorker dbWorker;

    public void contextInitialized(ServletContextEvent sce) {
        String userName = sce.getServletContext().getInitParameter("db_username");
        String password = sce.getServletContext().getInitParameter("db_password");
        String url = "jdbc:mysql://localhost:3306/forum_db?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        dbWorker = new DBWorkerImpl(url, userName, password);
        sce.getServletContext().setAttribute("dbWorker", dbWorker);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        if (dbWorker != null) {
            dbWorker.closeSession();
        }
    }
}
