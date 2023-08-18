package co.com.bancolombia.usecase.getinformation;

import co.com.bancolombia.model.InformationGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetInformationUseCase {

    private final InformationGateway informationGateway;

    public Mono<String> getInformation(String id) {
        return informationGateway.getInformation(id);
    }
}
