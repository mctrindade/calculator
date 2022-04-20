package br.com.wit.restapi.controllers;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "calculator", description = "Endpoint realizações de calculo")
@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);
	
	@Autowired
	private CalculatorService calculatorService;
	
	@ApiOperation(value = "Operation of sum")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Result of the sum"),
			@ApiResponse(code = 404, message = "Operation invalid") })
	@GetMapping(path ="sum", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BigDecimal> sum(@RequestParam("a") BigDecimal a, @RequestParam("b") BigDecimal b)  {
		LOGGER.info("[Project Rest API] - method sum [values {} | {}]", a, b);
		BigDecimal result = calculatorService.sum(a, b, "");
		LOGGER.info("[Project Rest API] - method sum [values {} + {} = {}]", a, b, result);
		return ResponseEntity.ok(result);
	}
	
	@ApiOperation(value = "Operation of Subtraction")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Subtraction result"),
			@ApiResponse(code = 404, message = "Operation invalid") })
	@GetMapping(path = "subtract", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BigDecimal> subtract(@RequestParam("a") BigDecimal a, @RequestParam("b") BigDecimal b)  {
		LOGGER.info("[Project Rest API] - method subtract [values {} | {}]", a, b);
		BigDecimal result = calculatorService.subtract(a, b, "");
		LOGGER.info("[Project Rest API] - method subtract [values {} - {} = {}]", a, b, result);
		return ResponseEntity.ok(result);
	}
	
	@ApiOperation(value = "Operation of multiplication")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Result of multiplication"),
			@ApiResponse(code = 404, message = "Operation invalid") })
	@GetMapping(path = "multiply", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BigDecimal> multiply(@RequestParam("a") BigDecimal a, @RequestParam("b") BigDecimal b)  {
		LOGGER.info("[Project Rest API] - method multiply [values {} | {}]", a, b);
		BigDecimal result = calculatorService.multiply(a, b, "");
		LOGGER.info("[Project Rest API] - method multiply [values {} * {} = {}]", a, b, result);
		return ResponseEntity.ok(result);
	}
	
	@ApiOperation(value = "Operation of division")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Result of division"),
			@ApiResponse(code = 404, message = "Operation invalid") })
	@GetMapping(path = "divide", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BigDecimal> divide(@RequestParam("a") BigDecimal a, @RequestParam("b") BigDecimal b)  {
		LOGGER.info("[Project Rest API] - method divide [values {} | {}]", a, b);
		BigDecimal result = calculatorService.divide(a, b, "");
		LOGGER.info("[Project Rest API] - method divide [values {} / {} = {}]", a, b, result);
		return ResponseEntity.ok(result);
	}


}
