package com.swan.ee.duplicateobserverdata.refactoring2;

public class ValueChangeEvent {
    private final Value _source;

    public ValueChangeEvent(Value source) {
        this._source = source;
    }

    public Value getSource() {
        return _source;
    }
}
