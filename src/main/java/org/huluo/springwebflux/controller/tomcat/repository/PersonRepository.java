package org.huluo.springwebflux.controller.tomcat.repository;

import org.huluo.springwebflux.controller.tomcat.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {

    Mono<Person> getPerson(int id);

    Flux<Person> allPeople();

    Mono<Void> savePerson(Mono<Person> person);

}
