package br.com.luciano.controller;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {
	
	
	@GetMapping(value = "/sum/{numberOne}/{numberTwo}")
	public BigDecimal sum(@PathVariable String numberOne, 
			@PathVariable String numberTwo) throws Exception{
		
		if(isNumeric(numberOne) && isNumeric(numberTwo)) {
			throw new Exception();
		}
		
		BigDecimal operandOne = convertBigDecimal(numberOne);
		BigDecimal operandTwo = convertBigDecimal(numberTwo);
		return operandOne.add(operandTwo);

	}
	
	@GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
	public BigDecimal subtraction(@PathVariable String numberOne, 
			@PathVariable String numberTwo) throws Exception{
		
		if(isNumeric(numberOne) && isNumeric(numberTwo)) {
			throw new Exception();
		}
		
		BigDecimal operandOne = convertBigDecimal(numberOne);
		BigDecimal operandTwo = convertBigDecimal(numberTwo);
		return operandOne.subtract(operandTwo);

	}
	
	
	@GetMapping(value = "/multiplication/{numberOne}/{numberTwo}")
	public BigDecimal multiplication(@PathVariable String numberOne, 
			@PathVariable String numberTwo) throws Exception{
		
		if(isNumeric(numberOne) && isNumeric(numberTwo)) {
			throw new Exception();
		}
		
		BigDecimal operandOne = convertBigDecimal(numberOne);
		BigDecimal operandTwo = convertBigDecimal(numberTwo);
		return operandOne.multiply(operandTwo);

	}
	
	@GetMapping(value = "/division/{numberOne}/{numberTwo}")
	public BigDecimal division(@PathVariable String numberOne, 
			@PathVariable String numberTwo) throws Exception{
		
		if(isNumeric(numberOne) && isNumeric(numberTwo)) {
			throw new Exception();
		}
		
		BigDecimal operandOne = convertBigDecimal(numberOne);
		BigDecimal operandTwo = convertBigDecimal(numberTwo);
		return operandOne.divide(operandTwo);

	}
	
	
	@GetMapping(value = "/math-power/{numberOne}/{strExponent}")
	public BigDecimal mathPower(@PathVariable String numberOne, 
			@PathVariable String strExponent) throws Exception{
		
		if(isNumeric(numberOne) && isNumeric(strExponent)) {
			throw new Exception();
		}
		
		BigDecimal operandOne = convertBigDecimal(numberOne);
		Integer exponent = Integer.parseInt(strExponent);
		return operandOne.pow(exponent);

	}
	
	private boolean isNumeric(String strNumber) {
		strNumber = strNumber.replace(",", ".");
		return StringUtils.isNumeric(strNumber);
	}
	
	private BigDecimal convertBigDecimal(String strNumber) {
		return new BigDecimal(strNumber);
	}

}
