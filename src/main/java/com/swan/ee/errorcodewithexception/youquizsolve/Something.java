package com.swan.ee.errorcodewithexception.youquizsolve;

public class Something {
    private String _errorMessage;

    public String getErrorMessage() {
        return _errorMessage;
    }

    public boolean method1() throws SomethingException {
        //...
        return true;
    }


    public boolean method2() throws SomethingException {
        //...
        return true;
    }


    public boolean method3() throws SomethingException{
        //...
        throw new SomethingException("method3: file open error.");
    }
}
