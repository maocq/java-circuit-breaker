package co.com.bancolombia.api;

import co.com.bancolombia.usecase.getinformation.GetInformationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final GetInformationUseCase getInformationUseCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        var id = serverRequest.queryParam("id").orElse("3b5cd73e-5508-4b1d-9bbe-83bcb3e6be54");

        return getInformationUseCase.getInformation(id)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("Hello");
    }
}
