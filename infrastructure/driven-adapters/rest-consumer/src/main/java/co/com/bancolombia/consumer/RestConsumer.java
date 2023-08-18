package co.com.bancolombia.consumer;

import co.com.bancolombia.model.InformationGateway;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestConsumer implements InformationGateway {
    private final WebClient client;


    @Override
    @CircuitBreaker(name = "getInformation", fallbackMethod = "getInformationFallback")
    public Mono<String> getInformation(String id) {
        return client
                .get()
                .uri("/v3/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getInformationFallback(Exception ignored) {
        return client
                .get()
                .uri("/v3/3b5cd73e-5508-4b1d-9bbe-83bcb3e6be54")
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> response + "\n\nException circuit:" + ignored.getClass().getName());
    }
}
