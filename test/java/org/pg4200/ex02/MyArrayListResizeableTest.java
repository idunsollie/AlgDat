package org.pg4200.ex02;

import org.pg4200.les02.list.MyListTestTemplate;

public class MyArrayListResizeableTest extends MyListTestTemplate {

    @Override
    protected <T> MyArrayListResizeable getNewInstance(Class<T> klass) {
        return new MyArrayListResizeable<>(1);
    }
}
