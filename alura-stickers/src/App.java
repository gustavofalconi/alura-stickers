import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
	
	public static void main(String[] args) throws Exception {
		
		// fazer uma conexão HTTP e buscar os top 250 filmes
		
//		ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
//		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		
//		ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
//		String url = "https://api.nasa.gov/planetary/apod?api_key=scrj9RKGZ9xIHc9AD3NfbrPM5QQvYB6j2NG3828n&start_date=2022-06-12&end_date=2022-06-14";
		
		String url = "http://localhost:8080/linguagens";
		ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
		
		var http = new ClienteHttp();
		String json = http.buscaDados(url);
		

			
		//exibir e manipular os dados
		
		List<Conteudo> conteudos = extrator.extraiConteudos(json);
		
		var geradora = new GeradoraDeFigurinhas();
		
		for (int i = 0; i<4; i++) {
			
		Conteudo conteudo = conteudos.get(i);
		
		
		InputStream	inputStream = new URL(conteudo.urlImagem()).openStream();
		
		String nomeArquivo ="saida/"+ conteudo.titulo().replace(":", "-") + ".png";
		
		
		geradora.cria(inputStream, nomeArquivo);
			
		System.out.println(conteudo.titulo());
		System.out.println();
		};
		
	}
}
