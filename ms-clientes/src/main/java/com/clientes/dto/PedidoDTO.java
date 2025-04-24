package com.clientes.dto;

public class PedidoDTO {
	 private Long id;
	    private Double total;
	    private Long idEstatus;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Double getTotal() {
			return total;
		}
		public void setTotal(Double total) {
			this.total = total;
		}
		public Long getIdEstatus() {
			return idEstatus;
		}
		public void setIdEstatus(Long idEstatus) {
			this.idEstatus = idEstatus;
		}


}
