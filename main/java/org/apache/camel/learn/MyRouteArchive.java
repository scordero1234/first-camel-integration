package org.apache.camel.learn;

import java.sql.Connection;
import java.sql.Statement;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.apache.commons.dbcp2.BasicDataSource;



/**
 * A Camel Java DSL Router
 @author Santiago Cordero
 */
public class MyRouteArchive extends RouteBuilder{
    DataFormat bindy = new BindyCsvDataFormat(CreditCardData.class);
  
        @Override
        public void configure() throws Exception {
                
                /**Creacion de la tabla */
                BasicDataSource dataSource = new BasicDataSource();
                dataSource.setDriverClassName("org.postgresql.Driver");
                dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
                dataSource.setUsername("postgres");
                dataSource.setPassword("postgres");
                try (Connection connection = dataSource.getConnection();
                         Statement statement = connection.createStatement()) {
                                String createTableQuery = "CREATE TABLE IF NOT EXISTS datosProcesadosOK (CODIGO SERIAL PRIMARY KEY, ID varchar(10),LIMITE varchar(10),SEXO varchar(10),EDUCACION varchar(10),CASADO varchar(10),EDAD varchar(10),PAGO_0 varchar(10),PAGO_2 varchar(10),PAGO_3 varchar(10),PAGO_4 varchar(10),PAGO_5 varchar(10),PAGO_6 varchar(10),FACTURA_1 varchar(10),FACTURA_2 varchar(10),FACTURA_3 varchar(10),FACTURA_4 varchar(10),FACTURA_5 varchar(10),FACTURA_6 varchar(10),PAY_AMT_1 varchar(10),PAY_AMT_2 varchar(10),PAY_AMT_3 varchar(10),PAY_AMT_4 varchar(10),PAY_AMT_5 varchar(10),PAY_AMT_6 varchar(10),DEFAULT_PAYMENT_NEXT_MONTH varchar(10));";
                        statement.executeUpdate(createTableQuery);
                         } catch (Exception e) {
                        e.printStackTrace();
                         }    

                        
                from("file:src/datos?noop=true&fileName=cardsclients.csv")
                        .to("sftp:localhost:2222/upload?username=foo&password=pass");
 
                from("sftp:localhost:2222/upload?noop=true&username=foo&password=pass")
                .unmarshal(bindy)
                .process(new MyProcessor())                
                .to("log:output"); 
     
        }

        


}
        
