package org.huluo.myappeventlistener;

import java.util.EventListener;

public interface MyListener<E extends MyEvent> extends EventListener {
    void onAppEvent(E event);
}
