package br.com.luciano;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	

	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double sum(@PathVariable String numberOne, 
			@PathVariable String numberTwo) throws Exception{
		
		if(isNumeric(numberOne) && isNumeric(numberTwo)) {
			throw new Exception();
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);

	}
	
	private boolean isNumeric(String strNumber) {
		strNumber = strNumber.trim();
		strNumber = strNumber.replace(",", ".");
		return StringUtils.isNumeric(strNumber);
	}
	
	private Double convertToDouble(String strNumber) {
		return Double.parseDouble(strNumber);
	}

}
