package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;


public class MyRouteArchivePipeline extends RouteBuilder{
    DataFormat bindy = new BindyCsvDataFormat(CreditCardData.class);
  
        @Override
        public void configure() throws Exception {
   
                from("file:src/datos?noop=true&fileName=cardsclients.csv")
                .pipeline()
                .process("myProcessor")
                .to("log:output");
                
        }
        
    

}
