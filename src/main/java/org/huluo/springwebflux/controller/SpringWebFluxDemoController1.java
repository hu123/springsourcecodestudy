package org.huluo.springwebflux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @see <a href="http://www.infoq.com/cn/articles/reactor-by-example">http://www.infoq.com/cn/articles/reactor-by-example</a>
 */
@Controller
public class SpringWebFluxDemoController1 {

    @RequestMapping("hello/{who}")
    @ResponseBody
    public Mono<String> sayHello(@PathVariable String who) {
        return Mono.just(who).map(s -> "my name is" + who);
    }

    @ResponseBody
    @RequestMapping("delayMono")
    public Mono<String> delayMono() {
        return Mono.just("myName is huluo ").delaySubscription(Duration.ofSeconds(20));
    }

}
