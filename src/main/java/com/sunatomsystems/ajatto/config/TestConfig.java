package com.sunatomsystems.ajatto.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sunatomsystems.ajatto.enums.StatusPedido;
import com.sunatomsystems.ajatto.models.CategoriaModel;
import com.sunatomsystems.ajatto.models.ClienteModel;
import com.sunatomsystems.ajatto.models.FornecedorModel;
import com.sunatomsystems.ajatto.models.ItemPedidoModel;
import com.sunatomsystems.ajatto.models.PedidoModel;
import com.sunatomsystems.ajatto.models.ProdutoModel;
import com.sunatomsystems.ajatto.models.UsuarioModel;
import com.sunatomsystems.ajatto.repositories.CategoriaRepositorio;
import com.sunatomsystems.ajatto.repositories.ClienteRepositorio;
import com.sunatomsystems.ajatto.repositories.FornecedorRepositorio;
import com.sunatomsystems.ajatto.repositories.ItensPedidoRepositorio;
import com.sunatomsystems.ajatto.repositories.PedidoRepositorio;
import com.sunatomsystems.ajatto.repositories.ProdutoRepositorio;
import com.sunatomsystems.ajatto.repositories.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {	
	
	@Autowired
	private UsuarioRepositorio usuRep;
	
	@Autowired
	private ClienteRepositorio cliRep;
	
	@Autowired
	private FornecedorRepositorio fornRep;
	
	@Autowired
	private CategoriaRepositorio catRep;
	
	@Autowired
	private PedidoRepositorio pedRep;
	
	@Autowired
	private ProdutoRepositorio prodRep;
	
	@Autowired
	private ItensPedidoRepositorio itensPedRep;	
	

	@Override
	public void run(String... args) throws Exception {		
		
		UsuarioModel usu1 = new UsuarioModel(null, "Camila Souza", "camilinha", "123456");
		UsuarioModel usu2 = new UsuarioModel(null, "João Pedro", "joaozinho", "654321");
		UsuarioModel usu3 = new UsuarioModel(null, "Thiago Bochino", "bochinozika", "123456");			
		usuRep.saveAll(Arrays.asList(usu1, usu2, usu3));			
		
		//*******Clientes******************************		
		
		ClienteModel c1 = new ClienteModel(null, "Maria do Carmo", "mariacarmo@hotmail.com", "119988776655");
		ClienteModel c2 = new ClienteModel(null, "Jao de Souza" ,"jao@gmail.com", "119988776644");
		ClienteModel c3 = new ClienteModel(null, "Ludmilla Silva", "ludmila@gmail.com", "11998563569");							
		cliRep.saveAll(Arrays.asList(c1, c2, c3));			
		
		CategoriaModel cat1 = new CategoriaModel(null, "Higiene");
		CategoriaModel cat2 = new CategoriaModel(null, "Farmácia");
		CategoriaModel cat3 = new CategoriaModel(null, "Alimenticio");
		CategoriaModel cat4 = new CategoriaModel(null, "Casa & Banho");
		CategoriaModel cat5 = new CategoriaModel(null, "Cozinha");
		catRep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		
		//****Fornecedores****************************
		
		FornecedorModel fo1 = new FornecedorModel(null, "Zulu Corps", "Rua das Flores, 156", "11963568745", "25698635468965");
		FornecedorModel fo2 = new FornecedorModel(null, "Diamond Hall", "Rua das Glórias, 380", "11978523595", "15975315648236");
		FornecedorModel fo3 = new FornecedorModel(null, "Machine Roles", "Rua das Dores, 351", "11920359865", "639852147852369");
		FornecedorModel fo4 = new FornecedorModel(null, "Probiótica", "Rua dos Bandeirantes, 369", "119789654125", "74123698521478");
		FornecedorModel fo5 = new FornecedorModel(null, "Max Titanium", "Rua das Clinícas, 963", "11932165498", "85275315978965");
		FornecedorModel fo6 = new FornecedorModel(null, "Dyamatize", "Rua das Graças, 981", "11958236974", "85296374185236");
		fornRep.saveAll(Arrays.asList(fo1, fo2, fo3, fo4, fo5, fo6));
		
		//************   Produtos   *********************
		
		ProdutoModel prod1 = new ProdutoModel(null, "Alcool Zulu 70%", 
				40.0, 27.0, "Alcool para limpar e desinfetar seu ambiente");
		
		prod1.setCategoriaProduto(cat3);
		prod1.setFornecedor(fo3);
		
		ProdutoModel prod2 = new ProdutoModel(null, "Pasta de Dente colgate",
				27.0, 8.0, "pasta recomendada de 8 a cada 10 dentistas");
		
		prod2.setCategoriaProduto(cat5);
		prod2.setFornecedor(fo1);
		
		ProdutoModel prod3 = new ProdutoModel(null, "Toalha de Rosto Anvel",
				17.0, 9.0, "Toalha de rosto para uso e decoração");
		
		prod3.setCategoriaProduto(cat1);
		prod3.setFornecedor(fo6);
		
		ProdutoModel prod4 = new ProdutoModel(null, "Algodão 70D",
				10.0, 3.0 , "Pacote de algodão com 6 maços, macios e leves para a pele");
		
		prod4.setCategoriaProduto(cat3);
		prod4.setFornecedor(fo2);
		
		ProdutoModel prod5 = new ProdutoModel(null, "PAPEL ABSORVENTE",
				25.0, 11.96, "");
		
		prod5.setCategoriaProduto(cat5);
		prod5.setFornecedor(fo2);
		
		ProdutoModel prod6 = new ProdutoModel(null, "LAMINAÇÃO DE PAPEL",
				17.80, 9.99, "");
		
		prod6.setCategoriaProduto(cat1);
		prod6.setFornecedor(fo1);
		
		ProdutoModel prod7 = new ProdutoModel(null, "LAPIS DE OLHO (PRETO)",
				18.90, 5.98, "");
		
		prod7.setCategoriaProduto(cat3);
		prod7.setFornecedor(fo3);
		
		ProdutoModel prod8 = new ProdutoModel(null, "ALGODAO DISCO 35G APOLO",
				45.00, 27.65, "");
		
		prod8.setCategoriaProduto(cat5);
		prod8.setFornecedor(fo3);
		
		ProdutoModel prod9 = new ProdutoModel(null, "KIT ESCOVA PENTE ROSA-REDONDAS FIONA",
				70.00, 35.00, "");		
		
		prod9.setCategoriaProduto(cat1);
		prod9.setFornecedor(fo1);
		
		ProdutoModel prod10 = new ProdutoModel(null, "PINCEL P/ SOBRANCELHA",				
				7.00, 3.99, "");		
		
		prod10.setCategoriaProduto(cat3);
		prod10.setFornecedor(fo3);
		
		ProdutoModel prod11 = new ProdutoModel(null, "PINÇA RETA P/ SOBRANCELHA",
				17.00, 11.00, "");		
		
		prod11.setCategoriaProduto(cat2);
		prod11.setFornecedor(fo5);
		
		ProdutoModel prod12 = new ProdutoModel(null, "Creme de barbear Bozzano",
				52.00, 17.00, "");				
		
		prod12.setCategoriaProduto(cat1);
		prod12.setFornecedor(fo6);
		
		prodRep.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6,
				prod7, prod8, prod9, prod10, prod11, prod12));
		
		//********Pedidos***************

		PedidoModel ped1 = new PedidoModel(null, LocalDateTime.now().minusDays(14), c1, usu1, StatusPedido.SEPARANDO);
		PedidoModel ped2 = new PedidoModel(null, LocalDateTime.now().minusDays(11), c1, usu1, StatusPedido.ENVIADO);
		PedidoModel ped3 = new PedidoModel(null, LocalDateTime.now().minusDays(9), c2, usu2, StatusPedido.PAGO);
		PedidoModel ped4 = new PedidoModel(null, LocalDateTime.now().minusDays(8), c2, usu3, StatusPedido.SEPARANDO);
		PedidoModel ped5 = new PedidoModel(null, LocalDateTime.now().minusDays(7), c2, usu2, StatusPedido.SEPARANDO);
		PedidoModel ped6 = new PedidoModel(null, LocalDateTime.now().minusDays(6), c2, usu1, StatusPedido.CANCELADO);
		PedidoModel ped7 = new PedidoModel(null, LocalDateTime.now().minusDays(5), c1, usu2, StatusPedido.SEPARANDO);
		PedidoModel ped8 = new PedidoModel(null,  LocalDateTime.now().minusDays(2), c3, usu1, StatusPedido.PAGO);
		PedidoModel ped9 = new PedidoModel(null,  LocalDateTime.now().minusDays(1), c2, usu3, StatusPedido.ENTREGUE);		
		pedRep.saveAll(Arrays.asList(ped1, ped2, ped3, ped4, ped5, ped6, ped7, ped8, ped9));		
		
		//******** Itens Pedidos   **********
		
		ItemPedidoModel ip1 = new ItemPedidoModel(ped1, prod4, 3, prod4.getPrecoUnitario());
		ItemPedidoModel ip2 = new ItemPedidoModel(ped1, prod1, 6, prod1.getPrecoUnitario());
		ItemPedidoModel ip3 = new ItemPedidoModel(ped1, prod3, 2, prod3.getPrecoUnitario());
		ItemPedidoModel ip4 = new ItemPedidoModel(ped2, prod2, 3, prod2.getPrecoUnitario());
		ItemPedidoModel ip5 = new ItemPedidoModel(ped3, prod4, 5, prod4.getPrecoUnitario());
		ItemPedidoModel ip6 = new ItemPedidoModel(ped4, prod1, 8, prod1.getPrecoUnitario());
		ItemPedidoModel ip7 = new ItemPedidoModel(ped5, prod2, 9, prod2.getPrecoUnitario());
		ItemPedidoModel ip8 = new ItemPedidoModel(ped6, prod11, 10, prod11.getPrecoUnitario());
		ItemPedidoModel ip9 = new ItemPedidoModel(ped7, prod12, 2, prod12.getPrecoUnitario());
		ItemPedidoModel ip10 = new ItemPedidoModel(ped7, prod8, 2, prod8.getPrecoUnitario());
		ItemPedidoModel ip11 = new ItemPedidoModel(ped7, prod9, 6, prod9.getPrecoUnitario());
		ItemPedidoModel ip12 = new ItemPedidoModel(ped8, prod5, 3, prod5.getPrecoUnitario());
		ItemPedidoModel ip13 = new ItemPedidoModel(ped8, prod3, 8, prod3.getPrecoUnitario());
		ItemPedidoModel ip14 = new ItemPedidoModel(ped9, prod9, 25, prod9.getPrecoUnitario());
		ItemPedidoModel ip15 = new ItemPedidoModel(ped9, prod7, 6, prod7.getPrecoUnitario());
		
		itensPedRep.saveAll(Arrays.asList(ip1, ip2, ip3,
				ip4, ip5, ip6, ip7, ip8, ip9, ip10, ip11, ip12, ip13, ip14, ip15));			
						
		
	}		
}