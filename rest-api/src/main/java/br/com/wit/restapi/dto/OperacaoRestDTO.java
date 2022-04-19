package br.com.wit.restapi.dto;

import java.math.BigDecimal;

import br.com.wit.restapi.enums.OperacaoEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OperacaoRestDTO {
	
	private BigDecimal valueA;
	
	private BigDecimal valueB;
	
	private OperacaoEnum operacao;
	
}