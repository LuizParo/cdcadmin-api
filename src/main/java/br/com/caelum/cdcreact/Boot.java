package br.com.caelum.cdcreact;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import br.com.caelum.cdcreact.daos.AutorDao;
import br.com.caelum.cdcreact.daos.LivroDao;
import br.com.caelum.cdcreact.models.Autor;
import br.com.caelum.cdcreact.models.Livro;

@Service
@SpringBootApplication
public class Boot implements CommandLineRunner {
  
  @Autowired
  private AutorDao autorDao;
  
  @Autowired
  private LivroDao livroDao;

	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}

  @Override
  public void run(String... args) throws Exception
  {
    Autor joao = new Autor();
    joao.setNome("João da Silva");
    joao.setEmail("joao.silva@email.com");
    joao.setSenha("123456");
    
    Autor maria = new Autor();
    maria.setNome("Maria José");
    maria.setEmail("maria.jose@email.com");
    maria.setSenha("123456");
    
    Autor ronaldinhoGaucho = new Autor();
    ronaldinhoGaucho.setNome("Ronaldinho Gaúcho");
    ronaldinhoGaucho.setEmail("ronaldinho.gaucho@email.com");
    ronaldinhoGaucho.setSenha("dibre123");
    
    this.autorDao.save(Arrays.asList(joao, maria, ronaldinhoGaucho));
    
    Livro livroJoao = new Livro("A arte de ser João", BigDecimal.ONE, joao);
    Livro livroMaria = new Livro("A vida de uma Maria", BigDecimal.ONE, maria);
    Livro livroRonaldinhoGaucho = new Livro("O Rei do Dibre!", BigDecimal.TEN, ronaldinhoGaucho);
    
    this.livroDao.save(Arrays.asList(livroJoao, livroMaria, livroRonaldinhoGaucho));
  }
}
