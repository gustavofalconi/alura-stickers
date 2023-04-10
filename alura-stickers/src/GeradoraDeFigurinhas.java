import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
	
	
	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		
		//leitura da imagem
		//InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// cria nova imagem em memória com transparência e tamanho novo
		
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		//copiar a imagem original para a nova imagem (em memória)
		
		Graphics2D graphics =	(Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		//configurar a fonte
		
		var fonte = new Font("Impact", Font.BOLD, 64);
		graphics.setColor(Color.yellow);
		graphics.setFont(fonte);
		
		// escrever uma frase na nova imagem
		
		String frase = "TOPZERA";
		FontMetrics metrics = graphics.getFontMetrics(); //calcular tamanho da fonte
		int centralizado = (largura - metrics.stringWidth(frase)) / 2;
		graphics.drawString(frase, centralizado, novaAltura - 100);
		
		
		//escrever a nova imagem em um arquivo
		
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
		
	}
}
