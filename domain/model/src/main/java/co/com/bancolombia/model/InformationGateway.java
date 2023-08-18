package co.com.bancolombia.model;

import reactor.core.publisher.Mono;

public interface InformationGateway {

    Mono<String> getInformation(String id);
}
