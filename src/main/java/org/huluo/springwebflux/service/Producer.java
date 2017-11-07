package org.huluo.springwebflux.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service
public class Producer {

    public Mono<ServerResponse> fetch(ServerRequest serverRequest) {
        return ok().contentType(MediaType.APPLICATION_JSON).body(Flux.just("value"), String.class);
    }
}
