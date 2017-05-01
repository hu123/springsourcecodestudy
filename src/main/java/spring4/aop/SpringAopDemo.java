package spring4.aop;

import org.springframework.aop.framework.ProxyFactory;
import spring4.Service;
import spring4.ServiceImpl;

/**
 * Created by weixin:javajidi_com.
 */
//详情参见:
//http://www.jianshu.com/p/1dd6a26c881b
public class SpringAopDemo {

    public static void main(String[] arg) {
        Service service = new ServiceImpl();//
        //使用代理工厂为目标对象创建代理，并织入我们自己的advice逻辑
        ProxyFactory proxyFactoryBean = new ProxyFactory(service);
//        proxyFactoryBean.setTarget();//设置目标对象
        proxyFactoryBean.addAdvice(new BeforeAdvice());//为目标对象织入增强
//        proxyFactoryBean.addAdvice(new AfterAdvice());
//        proxyFactoryBean.addAdvice(new RoundAdvice());
        Service proxy = (Service) proxyFactoryBean.getProxy();

        System.out.println(proxy.getClass().getName());
        proxy.print("test");
    }
}

