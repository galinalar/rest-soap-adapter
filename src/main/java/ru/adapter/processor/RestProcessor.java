package ru.adapter.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import ru.adapter.model.RestRequest;

public class RestProcessor implements Processor {
    
    @Override
    public void process(Exchange exchange) throws Exception {
        RestRequest restRequest = exchange.getIn().getBody(RestRequest.class);
        exchange.getIn().setBody(restRequest.getFirst()+" "+restRequest.getSecond());
    }
}
