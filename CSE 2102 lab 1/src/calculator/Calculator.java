package calculator;

public class Calculator {
	
	String _power = "off";
	
    public Calculator() {
    	_power = "on";
    }
	
	public String getPowerStatus() {
		return _power;
	}

    public int addition(String x, String y) {
       return new Integer(x) + new Integer(y);
    }
    
    public int subtraction(String x, String y) {
       return new Integer(x) - new Integer(y);
    }
    
    public int multiplication(String x, String y) {    
       return new Integer(x) * new Integer(y);
    }
    
    public int division(String x, String y) {
       return new Integer(x) / new Integer(y);
    }
}
