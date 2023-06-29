package org.camilo.apiservlet.webapp.headers.configs;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;


import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@ApplicationScoped
public class ProducerResources  {

    @Resource(name = "jdbc/mysqlDB")
    private DataSource ds;

    @Inject
    private  Logger log;

    @Produces
    @RequestScoped
    @MysqlConn
    private Connection beanConnection() throws SQLException {
        return ds.getConnection();
    }

    @Produces
    private Logger beanLogger(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    public void close(@Disposes @MysqlConn Connection connection) throws SQLException {
        connection.close();
        log.info("Cerrando la conexion a la bbdd mysql");

    }
}
