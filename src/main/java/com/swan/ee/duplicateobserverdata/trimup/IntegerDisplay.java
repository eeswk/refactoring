package com.swan.ee.duplicateobserverdata.trimup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IntegerDisplay extends Frame implements ActionListener, ValueListener {
    private final Label _octalLabel = new Label("0");
    private final Label _decimalLabel = new Label("0");
    private final Label _hexadecimalLabel = new Label("0");
    private final Button _incrementButton = new Button("+");
    private final Button _decrementButton = new Button("-");


    private Value _value = new Value(0);

    private final Graph _graphCircle = Graph.createGraph(Graph.CIRCLE, 100, 100);
    private final Graph _graphRectangle = Graph.createGraph(Graph.RECTANGLE, 100, 50);

    public IntegerDisplay() {
        super("IntegerDisplay");

        setLayout(new BorderLayout());

        Panel panel = new Panel(new GridLayout(4, 2));

        panel.add(new Label("Octal: "));
        panel.add(_octalLabel);
        panel.add(new Label("Decimal: "));
        panel.add(_decimalLabel);
        panel.add(new Label("Hexadecimal: "));
        panel.add(_hexadecimalLabel);
        panel.add(_incrementButton);
        panel.add(_decrementButton);

        add(panel, BorderLayout.NORTH);
        add(_graphCircle, BorderLayout.CENTER);
        add(_graphRectangle, BorderLayout.SOUTH);

        _incrementButton.addActionListener(this);
        _decrementButton.addActionListener(this);

        _value.addValueListener(this);

        _value.addValueListener(_graphCircle);
        _value.addValueListener(_graphRectangle);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _incrementButton) {
            setValue(_value.getValue() + 1);
        } else if (e.getSource() == _decrementButton) {
            setValue(_value.getValue() - 1);
        }
    }

    public int getValue() {
        return _value.getValue();
    }

    public void setValue(int value) {
        _value.setValue(value);
//        _octalLabel.setText(Integer.toString(_value.getValue(), 8));
//        _decimalLabel.setText(Integer.toString(_value.getValue(), 10));
//        _hexadecimalLabel.setText(Integer.toString(_value.getValue(), 16));
    }

    @Override
    public void valueChanged(ValueChangeEvent e) {
        if (e.getSource() == _value) {
            _octalLabel.setText(Integer.toString(_value.getValue(), 8));
            _decimalLabel.setText(Integer.toString(_value.getValue(), 10));
            _hexadecimalLabel.setText(Integer.toString(_value.getValue(), 16));
        }
    }
}
