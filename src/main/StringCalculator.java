package main;


public class StringCalculator {
	
	public StringCalculator() {
		
	}
	//dasdasdasdassd
	public int add(String expression) {
		int total = 0;
		if(expression == null || expression.isEmpty()) {
			return total;
		} else {
			String delimiter = getDelimiter(expression);
			String[] values;
			if(delimiter != null) {
				values = expression.split(",|\n" + "|" + delimiter);				
			} else {
				values = expression.split(",|\n");				
			}

			for(String value : values) {
				if(!value.isEmpty() && value.length() < 4) {
					try {
						total += Integer.valueOf(value);
					} catch(NumberFormatException e) {
						
					}
				}
			}
		}
		return total;
	}
	
	public String getDelimiter(String expression) {
		if(expression.startsWith("//") && expression.contains("\n")) {
			return expression.substring(2, expression.indexOf("\n"));
		} else {
			return null;
		}
	}
}