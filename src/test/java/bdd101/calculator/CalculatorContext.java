package bdd101.calculator;

public class CalculatorContext {

    private static ThreadLocal<CalculatorContext> threadContext = 
            new ThreadLocal<CalculatorContext>();
    
    public static CalculatorContext context() {
        return threadContext.get();
    }
    
    public static Calculator calculator() {
        return context().getCalculator();
    }
    
    public static void initialize() {
        // one does not rely on ThreadLocal#initialValue()
        // so that one is sure only initialize create a new
        // instance
        threadContext.set(new CalculatorContext());
    }
    public static void dispose () {
        threadContext.remove();
    }
    
    private Calculator calculator;
    private Exception lastError;
    
    public CalculatorContext() {
        calculator = new Calculator();
    }
    
    public Calculator getCalculator() {
        return calculator;
    }
    
    public void setLastError(Exception lastError) {
        this.lastError = lastError;
    }
    
    public Exception getLastError() {
        return lastError;
    }
}
