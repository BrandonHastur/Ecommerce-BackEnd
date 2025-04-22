package com.commons.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name = "PEDIDO")
public class Pedido {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "SEQ_PEDIDO" )
	@SequenceGenerator (name = "SEQ_PEDIDO", sequenceName = "SEQ_PEDIDO", allocationSize = 1)
	@Column(name = "ID_PEDIDO")
	Long id;
	
	@Column(name = "ID_CLIENTE")
	Long idCliente;
	
	@Column(name = "TOTAL")
	Long total;
	
	@Column(name = "ID_ESTATUS")
	Long idEstatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Long idEstatus) {
		this.idEstatus = idEstatus;
	}

	

}
