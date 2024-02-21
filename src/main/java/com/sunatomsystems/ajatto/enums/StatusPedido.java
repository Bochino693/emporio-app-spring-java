package com.sunatomsystems.ajatto.enums;

public enum StatusPedido {

	SEPARANDO(1),
	AGUARDANDO_PAGAMENTO(2), 
	PAGO(3),	
	ENVIADO(4),
	CANCELADO(5),
	ENTREGUE(6);
	
	private int code;
	
	private StatusPedido(int code) {
		this.code = code;
	}
	
	public int getCode() {
			return code;
	}
	
	public static StatusPedido valorOf(int code) {		
		for(StatusPedido valor : StatusPedido.values()) {
			if(valor.getCode() == code) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Você inseriu um código que não está associado a uma status de Pedido.");
	}

}
