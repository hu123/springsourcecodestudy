package org.huluo.myappeventlistener;

public class MyEventListenerAppContext implements MyAppContext {


    private MyEvent myEvent;
    private MyListener myListener;

    public MyEventListenerAppContext(MyEvent myEvent, MyListener myListener) {
        this.myEvent = myEvent;
        this.myListener = myListener;
    }

    public MyEventListenerAppContext() {

    }

    @Override
    public void publishEvent(MyEvent myEvent) {
        invokeListenerMethod(myEvent);
    }


    private void invokeListenerMethod(MyEvent myEvent) {
        myListener.onAppEvent(myEvent);
    }
}
