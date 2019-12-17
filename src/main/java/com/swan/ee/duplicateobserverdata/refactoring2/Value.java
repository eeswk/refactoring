package com.swan.ee.duplicateobserverdata.refactoring2;

import java.util.ArrayList;
import java.util.List;

public class Value {
    private int value = 0;

    private final List<ValueListener> _listeners = new ArrayList<>();

    public void addValueListener(ValueListener listener) {
        _listeners.add(listener);
    }

    public Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyToListeners();
    }

    private void notifyToListeners() {
        for (ValueListener listener : _listeners) {
            listener.valueChanged(new ValueChangeEvent(this));

        }
    }
}
