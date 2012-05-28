package bdd101.calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final Map<String, Integer> context = new HashMap<String, Integer>();

    public void defineVariable(String variable, int value) {
        context.put(variable, value);
    }
    
    public void addToVariable(String variable, int value) {
        int existing = getVariableValueOrFail(variable);
        context.put(variable, value + existing);
    }
    
    public void addToVariable(String variable, String variableToAdd) {
        int other = getVariableValueOrFail(variableToAdd);
        addToVariable(variable, other);
    }
    
    public int getVariableValue(String variable) {
        return getVariableValueOrFail(variable);
    }

    protected int getVariableValueOrFail(String variable) {
        Integer existing = context.get(variable);
        if(existing==null)
            throw new IllegalStateException("Variable <" + variable + "> is not defined");
        return existing;
    }
}
