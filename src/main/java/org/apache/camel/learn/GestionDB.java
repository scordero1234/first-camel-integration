package org.apache.camel.learn;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.commons.dbcp2.BasicDataSource;

public class GestionDB implements Processor{

    public void createTable() throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        System.err.println("Creando tabla");
        try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                        String createTableQuery = "CREATE TABLE IF NOT EXISTS mytablwe (CODIGO SERIAL PRIMARY KEY, ID INT,LIMITE NUMERIC(10, 2),SEXO INT,EDUCACION INT,CASADO INT,EDAD INT,PAGO_0 INT,PAGO_2 INT,PAGO_3 INT,PAGO_4 INT,PAGO_5 INT,PAGO_6 INT,FACTURA_1 NUMERIC(10, 2),FACTURA_2 NUMERIC(10, 2),FACTURA_3 NUMERIC(10, 2),FACTURA_4 NUMERIC(10, 2),FACTURA_5 NUMERIC(10, 2),FACTURA_6 NUMERIC(10, 2),PAY_AMT_1 NUMERIC(10, 2),PAY_AMT_2 NUMERIC(10, 2),PAY_AMT_3 NUMERIC(10, 2),PAY_AMT_4 NUMERIC(10, 2),PAY_AMT_5 NUMERIC(10, 2),PAY_AMT_6 NUMERIC(10, 2),DEFAULT_PAYMENT_NEXT_MONTH INT);";
                statement.executeUpdate(createTableQuery);
                 } catch (Exception e) {
                e.printStackTrace();
                 }
    }

    @Override
    public void process(Exchange exchange) throws Exception {
      createTable();
    }

    
}
