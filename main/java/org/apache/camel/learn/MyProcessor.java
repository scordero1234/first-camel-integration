package org.apache.camel.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {


    public String procesaString(ArrayList<CreditCardData> creditCardList) {
        
        int errorCount = 0;
        int totalRows=creditCardList.size();

        ArrayList<CreditCardData> listaAgregar =new ArrayList<>();
        for (CreditCardData creditCard : creditCardList) {
               try {
              
                double bill1Value = Double.parseDouble(creditCard.getBill1());
                double bill6Value = Double.parseDouble(creditCard.getBill6());
                double bill2Value = Double.parseDouble(creditCard.getBill2());
                double bill3Value = Double.parseDouble(creditCard.getBill3());
                double bill4Value = Double.parseDouble(creditCard.getBill4());
                double bill5Value = Double.parseDouble(creditCard.getBill5());

                double pay1Value = Double.parseDouble(creditCard.getPay1());
                double pay2Value = Double.parseDouble(creditCard.getPay2());
                double pay3Value = Double.parseDouble(creditCard.getPay3());
                double pay4Value = Double.parseDouble(creditCard.getPay4());
                double pay5Value = Double.parseDouble(creditCard.getPay5());
                double pay6Value = Double.parseDouble(creditCard.getPay6());

                if (bill1Value <= 0 || bill2Value <= 0 || bill3Value <= 0 || bill4Value <= 0 || bill5Value <= 0 || bill6Value <= 0 ||
                pay1Value <= 0 || pay2Value <= 0 || pay3Value <= 0 || pay4Value <= 0 || pay5Value <= 0 || pay6Value <= 0) {
                    errorCount++;
                }else{
                    listaAgregar.add(creditCard);
                }

                
            } catch (NumberFormatException e) {
                errorCount++;
            } 
        }

        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("=================================================================================================================");
        stringBuilder5.append("Total de filas a agregar: " + listaAgregar.size() + " Filas Correctas: " + (totalRows - errorCount) + " Filas Erroneas: " + errorCount);
        System.err.println("Total de filas a agregar: " + listaAgregar.size());
        this.insertarDatos(listaAgregar);

        System.err.println("Filas Correctas: " + (totalRows - errorCount));
        System.err.println("Filas Erroneas: " + errorCount);
return "Total de filas a agregar: " + listaAgregar.size() + " Filas Correctas: " + (totalRows - errorCount) + " Filas Erroneas: " + errorCount;
    }
    public boolean insertarDatos(ArrayList<CreditCardData> listaAgregar) {
        boolean result = false;
        
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "postgres";
        
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO datosProcesadosOK (ID, LIMITE, SEXO, EDUCACION, CASADO, EDAD, PAGO_0, PAGO_2, PAGO_3, PAGO_4, PAGO_5, PAGO_6, FACTURA_1, FACTURA_2, FACTURA_3, FACTURA_4, FACTURA_5, FACTURA_6, PAY_AMT_1, PAY_AMT_2, PAY_AMT_3, PAY_AMT_4, PAY_AMT_5, PAY_AMT_6, DEFAULT_PAYMENT_NEXT_MONTH) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                   
                    for (CreditCardData creditCard : listaAgregar) {
                        statement.setString(1, creditCard.getId());
                        statement.setString(2, creditCard.getLimitBalance());
                        statement.setString(3, creditCard.getLimitBalance());
                        statement.setString(4, creditCard.getEducation());
                        statement.setString(5, creditCard.getMarriage());
                        statement.setString(6, creditCard.getAge());
                        statement.setString(7, creditCard.getPay0());
                        statement.setString(8, creditCard.getPay2());
                        statement.setString(9, creditCard.getPay3());
                        statement.setString(10, creditCard.getPay4());
                        statement.setString(11, creditCard.getPay5());
                        statement.setString(12, creditCard.getPay6());
                        statement.setString(13, creditCard.getBill1());
                        statement.setString(14, creditCard.getBill2());
                        statement.setString(15, creditCard.getBill3());
                        statement.setString(16, creditCard.getBill4());
                        statement.setString(17, creditCard.getBill5());
                        statement.setString(18, creditCard.getBill6());
                        statement.setString(19, creditCard.getPay_2());
                        statement.setString(20, creditCard.getPay_3());
                        statement.setString(21, creditCard.getPay_3());
                        statement.setString(22, creditCard.getPay_3());
                        statement.setString(23, creditCard.getPay_3());
                        statement.setString(24, creditCard.getPay_3());
                        statement.setString(25, creditCard.getDefaultPaymentNextMonth());
                        
                        statement.executeUpdate();
                    }
                
            } catch (SQLException e) {
                e.printStackTrace();
                    return false;
            }   

            
        return true;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        ArrayList<CreditCardData> creditCardList = exchange.getIn().getBody(ArrayList.class);
        procesaString(creditCardList);
    }
}
