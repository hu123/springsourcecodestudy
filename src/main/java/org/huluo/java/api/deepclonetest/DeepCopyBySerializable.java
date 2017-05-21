package org.huluo.java.api.deepclonetest;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class DeepCopy implements Serializable{

}
class DeepCopyWrapper implements Serializable{
    public DeepCopy deepCopy;

    //自定义的深克隆的方法实现
    public Object myClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        DeepCopyWrapper deepCopyWrapper = (DeepCopyWrapper) objectInputStream.readObject();
        return deepCopyWrapper;
    }
}

/**
 * 使用Serializable的方式来进行对象深拷贝,使用Serializable往往比较耗费性能。
 */
public class DeepCopyBySerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DeepCopyWrapper deepCopyWrapper = new DeepCopyWrapper();
        deepCopyWrapper.deepCopy = new DeepCopy();

        DeepCopyWrapper copyResult = (DeepCopyWrapper) deepCopyWrapper.myClone();
        //输出false代表深拷贝正确
        System.out.println(copyResult.deepCopy == deepCopyWrapper.deepCopy);
    }
}
