package com.swan.ee.duplicateobserverdata.trimup;

public class ValueChangeEvent {
    private final Value _source;

    public ValueChangeEvent(Value source) {
        this._source = source;
    }

    public Value getSource() {
        return _source;
    }
}
