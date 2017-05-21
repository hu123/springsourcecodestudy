import java.io.FileInputStream;
import java.io.IOException;

class MySecurityManager extends SecurityManager{

    @Override
    public void checkRead(String file) {
        if (file.endsWith("test")) {
            throw new SecurityException("没权限读不了额");
        }
    }
}
//实现自定义的SecurityManager
public class MySecurityManagerMain {
    public static void main(String[] args) throws NoSuchFieldException, IOException {
        MySecurityManager mySecurityManager = new MySecurityManager();
        System.setSecurityManager(mySecurityManager);
        //其实可以点开FileInputStream的源码来看,还是先调用了checkRead()方法,在进行目标操作
        FileInputStream fileInputStream = new FileInputStream("test");

        fileInputStream.read();

    }
}
