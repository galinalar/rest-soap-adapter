package ru.adapter.config;

import jaxb2.Add;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.soap.name.ElementNameStrategy;
import org.apache.camel.dataformat.soap.name.TypeNameStrategy;
import org.apache.camel.model.dataformat.SoapDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import ru.adapter.model.RestRequest;

@Component
public class RestConfig extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json).host("localhost").port(8081);

        String jaxbPackage = Add.class.getPackage().getName();
        ElementNameStrategy elStrat = new TypeNameStrategy();
        SoapDataFormat answer = new SoapDataFormat();
        answer.setVersion("1.2");
        answer.setElementNameStrategy(elStrat);
        answer.setContextPath(jaxbPackage);
        rest()
                .post("/add").type(RestRequest.class).produces(MediaType.APPLICATION_JSON_VALUE).to("direct:add")
                .get("/api/people").produces(MediaType.APPLICATION_JSON_VALUE).to("direct:hello");
        from("direct:hello").log("giyfy").transform().constant("LLL");
        from("direct:add").log(""+body()).marshal(answer).to("jms://http://tempuri.org/Add");
        /*from("direct:add").log(""+body())
                .setHeader(CxfConstants.OPERATION_NAME,
                        constant("ADD"))
                .to("cxf://http://tempuri.org/Add"+"?serviceClass=jaxb2.Add"
                +"&wsdlURL=http://www.dneonline.com/calculator.asmx?wsdl");*/
        //from("direct:add").log(""+body()).bean(RestProcessor.class);

        //rest("/say")
            //  .get("/hello").to("direct:hello")
           //     .get("/bye").consumes("application/json").to("direct:bye")
             //   .post("/bye").to("mock:update");

        //from("rest:get:/say").log("inside").to("direct:hello");

       // from("direct:hello")

               // .transform().constant("Hello World");

       // from("direct:bye")
               // .transform().constant("Bye World");
    }
}
