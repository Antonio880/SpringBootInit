// package br.com.antonio.screenmatch;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// import br.com.antonio.screenmatch.principal.Principal;
// import br.com.antonio.screenmatch.repository.SerieRepository;

// @SpringBootApplication
// public class ScreenmatchApplicationWeb implements CommandLineRunner {
// 	@Autowired
//     private SerieRepository repositorio;
// 	public static void main(String[] args) {
// 		SpringApplication.run(ScreenmatchApplication.class, args);
// 	}

// 	@Override
// 	public void run(String... args) throws Exception{
// 		Principal principal = new Principal(repositorio);
// 		principal.exibeMenu();
// 	}
// }
