package homework1;

import java.awt.*;

public class  ImpossibleSizeException extends Exception
{
	private Dimension alternative;
	
	public ImpossibleSizeException() {}
	
	public ImpossibleSizeException(String str){
		super(str);
		alternative = new Dimension(10, 10);
	}
	public Dimension getAlternativeDim() {
		return alternative;
	}
	
	
}