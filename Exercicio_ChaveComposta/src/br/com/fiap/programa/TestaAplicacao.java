package br.com.fiap.programa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Item;
import br.com.fiap.entity.Pedido;
import br.com.fiap.helper.VendasHelper;
import br.com.fiap.pk.PedidosPK;

public class TestaAplicacao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exercicio_ChaveComposta");
		EntityManager em = emf.createEntityManager();
		
		VendasHelper dao = new VendasHelper(em);
		
		try {
			Cliente cliente = new Cliente();
			cliente.setId(10);
			cliente.setEmpresa("Fiap");
			
			Endereco endereco = new Endereco();
			endereco.setRua("Lins de vasconcelos");
			endereco.setCidade("São Paulo");
			endereco.setCep("01538-001");
			endereco.setCliente(cliente);
			
			PedidosPK pkpedido = new PedidosPK();
			pkpedido.setCodigo(100);
			pkpedido.setCategoria("Livros");
			
			Pedido pedido = new Pedido();
			pedido.setIdpedido(15);
			pedido.setDatapedido(new Date());
			pedido.setPedidoPK(pkpedido);
			pedido.setCliente(cliente);
			
			Item item1 = new Item();
			item1.setQuantidade(2);
			
			Item item2 = new Item();
			item2.setQuantidade(3);
			
			pedido.getItens().add(item1);
			pedido.getItens().add(item2);
			
			cliente.getEnderecos().add(endereco);
			cliente.getPedidos().add(pedido);
			
			dao.salvar(cliente);
			JOptionPane.showMessageDialog(null, "Cliente incluído com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
