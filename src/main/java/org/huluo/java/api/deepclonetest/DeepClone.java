package org.huluo.java.api.deepclonetest;

class DeepCloneObject implements Cloneable{

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class DeepCloneWrapper implements Cloneable {
    public DeepCloneObject deepCloneObject;

    @Override
    public Object clone() throws CloneNotSupportedException {
        DeepCloneWrapper deepCloneWrapper = null;
        deepCloneWrapper = (DeepCloneWrapper) super.clone();

        if (this.deepCloneObject != null) {
            this.deepCloneObject = (DeepCloneObject) deepCloneObject.clone();
        }
        return deepCloneWrapper;
    }
}
/**
 * 用该demo演示深拷贝,即{@link DeepCloneWrapper}里的{@link DeepCloneObject}对象的引用指向了一个新的对象
 *
 */
public class DeepClone {
    public static void main(String[] args) throws CloneNotSupportedException {

        DeepCloneWrapper deepCloneWrapper = new DeepCloneWrapper();
        DeepCloneObject deepCloneObject = new DeepCloneObject();
        deepCloneWrapper.deepCloneObject = deepCloneObject;
        DeepCloneWrapper cloneResult = (DeepCloneWrapper) deepCloneWrapper.clone();
        //展示成员变量中引用的地址是不一样的,拷贝后的对象和原对象的成员变量引用的地址不再试引用到同一内存地址
        System.out.println(cloneResult.deepCloneObject == deepCloneWrapper.deepCloneObject);
    }

}