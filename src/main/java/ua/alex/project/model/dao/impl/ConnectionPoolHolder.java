package ua.alex.project.model.dao.impl;

import org.apache.commons.dbcp2.BasicDataSource;
import ua.alex.project.constants.Attributes;

import javax.sql.DataSource;
import java.util.ResourceBundle;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;
    public static DataSource getDataSource(){
        ResourceBundle bundle = ResourceBundle.getBundle(Attributes.DB_PROPERTIES_NAME);
        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl(bundle.getString(Attributes.DB_URL));
                    ds.setUsername(bundle.getString(Attributes.DB_USERNAME));
                    ds.setPassword(bundle.getString(Attributes.DB_PASSWORD));
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;

    }
}
