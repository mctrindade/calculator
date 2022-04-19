package br.com.wit.calculatorapi.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.wit.calculatorapi.dto.OperacaoCalculatorDTO;

@Service
public class OperacaoService {

	public BigDecimal calcular(OperacaoCalculatorDTO operacao) {
		// TODO Auto-generated method stub
		return operacao.getValueA().add(operacao.getValueB());
	}

}
