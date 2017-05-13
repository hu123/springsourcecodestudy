package org.huluo.myappeventlistener;

public class Main {
    public static void main(String[] args) {
        String source = new String("事件源");
        MyEvent myEvent = new MyEvent(source) {
        };

        MyListener<MyEvent> myEventMyListener = event -> {
            System.out.println("我来看下具体的事件源对象是啥样的----->" + event);
            System.out.println("哦嗦嘎,做出处理");
        };
        MyAppContext myAppContext = new MyEventListenerAppContext(myEvent, myEventMyListener);

        myAppContext.publishEvent(myEvent);


    }
}
