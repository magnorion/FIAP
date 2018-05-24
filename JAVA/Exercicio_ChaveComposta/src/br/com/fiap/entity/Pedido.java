package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.pk.PedidosPK;

@Entity
@Table(name="pedidos")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PedidosPK pedidoPK;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date datapedido;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@Column(name="idpedido")
	private int idpedido;
	
	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pedido")
	private Set<Item> itens = new LinkedHashSet<Item>();

	public PedidosPK getPedidoPK() {
		return pedidoPK;
	}

	public void setPedidoPK(PedidosPK pedidoPK) {
		this.pedidoPK = pedidoPK;
	}

	public Date getDatapedido() {
		return datapedido;
	}

	public void setDatapedido(Date datapedido) {
		this.datapedido = datapedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Item> getItens() {
		return itens;
	}

	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}
}
