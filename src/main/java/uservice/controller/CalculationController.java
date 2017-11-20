package uservice.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uservice.bean.Calculation;

@RestController
@RequestMapping("calculation")

@SuppressWarnings("unused")
public class CalculationController {
	private static final String PATTERN = "^-?+\\d+\\.?+\\d*$";

	@RequestMapping("power")
	public Calculation pow(@RequestParam(value = "base") String b, @RequestParam(value = "exponent") String e) {
		List<String> input = new ArrayList<>();
		input.add(b);
		input.add(e);
		List<String> output = new ArrayList<>();
		String powValue = "";
		if (b != null && e != null && b.matches(PATTERN) && e.matches(PATTERN)) {
			powValue = String.valueOf(Math.pow(Double.valueOf(b), Double.valueOf(e)));
		} else {
			powValue = String.valueOf("Base of/and Exponent is/are not set to numberic value.");
		}
		output.add(powValue);
		return new Calculation();
	}

	@RequestMapping(value = "/sqrt/{value:.+}", method = RequestMethod.GET)
	public Calculation sqrt(@PathVariable(value = "value") String aValue) {
		List<String> input = new ArrayList<>();
		input.add(aValue);
		List<String> output = new ArrayList<>();
		String sqrtValue = "";
		if (aValue != null && aValue.matches(PATTERN)) {
			sqrtValue = String.valueOf(Math.sqrt(Double.valueOf(aValue)));
		} else {
			sqrtValue = "Input value is not set no numberic value.";
		}
		output.add(sqrtValue);
		return new Calculation();
	}

}
