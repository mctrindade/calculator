package br.com.wit.restapi.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wit.restapi.services.CalculatorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculatorService;
	
	@ApiOperation(value = "Operation of sum")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Result of the sum"),
			@ApiResponse(code = 404, message = "Operation invalid") })
	@GetMapping("sum")
	public ResponseEntity<BigDecimal> sum(@RequestParam BigDecimal a, @RequestParam BigDecimal b)  {
		
		BigDecimal result = calculatorService.sum(a, b, "");
		
		return ResponseEntity.ok(result);
	}
	
	@ApiOperation(value = "Operation of Subtraction")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Subtraction result"),
			@ApiResponse(code = 404, message = "Operation invalid") })
	@GetMapping(path = "subtract", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BigDecimal> subtract(@RequestParam BigDecimal a, @RequestParam BigDecimal b)  {
		
		BigDecimal result = calculatorService.subtract(a, b, "");
		
		return ResponseEntity.ok(result);
	}
	
	@ApiOperation(value = "Operation of multiplication")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Result of multiplication"),
			@ApiResponse(code = 404, message = "Operation invalid") })
	@GetMapping(path = "multiply", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BigDecimal> multiply(@RequestParam BigDecimal a, @RequestParam BigDecimal b)  {
		
		BigDecimal result = calculatorService.multiply(a, b, "");
		
		return ResponseEntity.ok(result);
	}
	
	@ApiOperation(value = "Operation of division")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Result of division"),
			@ApiResponse(code = 404, message = "Operation invalid") })
	@GetMapping(path = "divide", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BigDecimal> divide(@RequestParam BigDecimal a, @RequestParam BigDecimal b)  {

		BigDecimal result = calculatorService.divide(a, b, "");
		
		return ResponseEntity.ok(result);
	}


}
