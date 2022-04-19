package br.com.wit.calculatorapi.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperacaoCalculatorDTO {

	private BigDecimal valueA;

	private BigDecimal valueB;

	private String operacao;

}
