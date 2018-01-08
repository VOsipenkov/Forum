package listeners;

import utils.DBWorker;
import utils.DBWorkerImpl;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static utils.Constants.*;

@WebListener
public class DbConnectionListener implements ServletContextListener {
    private DBWorker dbWorker;

    public void contextInitialized(ServletContextEvent sce) {
        String userName = sce.getServletContext().getInitParameter(USER_NAME_DATABASE);
        String password = sce.getServletContext().getInitParameter(USER_PASSWORD_DATABASE);
        String url = "jdbc:mysql://localhost:3306/forum_db?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        dbWorker = new DBWorkerImpl(url, userName, password);
        sce.getServletContext().setAttribute(DB_WORKER, dbWorker);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        if (dbWorker != null) {
            dbWorker.closeSession();
        }
    }
}
