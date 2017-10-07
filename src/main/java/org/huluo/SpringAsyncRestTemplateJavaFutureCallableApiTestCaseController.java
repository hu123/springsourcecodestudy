package org.huluo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringAsyncRestTemplateJavaFutureCallableApiTestCaseController {

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("get invoked");
        return "helloworld";
    }
}
