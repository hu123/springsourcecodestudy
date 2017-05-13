package org.huluo.spring.pathmatchingresourcepatternresolver;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StreamUtils;

public class PathMatchingResourcePatternResolverTest {


    @Test
    public void testName() throws Exception {
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = pathMatchingResourcePatternResolver.getResource("classpath:/simplelog.properties");

        StreamUtils.copy(resource.getInputStream(), System.out);



    }
}
