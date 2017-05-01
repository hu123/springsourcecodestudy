package spring4;


/**
 * <p>test
 *
 * {@link #print(java.lang.String)}
 * {@link org.springframework.web.context.ContextLoaderListener#contextInitialized(javax.servlet.ServletContextEvent)}
 * @see #print(java.lang.String)
 *
 *
 */
public class ServiceImpl implements Service {
    /**
     *
     * @param str
     */
    public void print(String str) {
        System.out.println("我是业务方法"+str);
    }
}
