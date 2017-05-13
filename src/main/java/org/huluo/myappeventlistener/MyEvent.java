package org.huluo.myappeventlistener;

public abstract class MyEvent {

    private Object source;

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public MyEvent(Object source) {
        this.source = source;
    }
}
