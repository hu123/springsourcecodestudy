package org.huluo.springwebflux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

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

}
