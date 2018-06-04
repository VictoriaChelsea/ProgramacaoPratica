package command;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;
import utils.CryptoAES;
import utils.Impressora;

public class FazerLogin implements Command {
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("username");
		String senha = request.getParameter("passwd");
		byte [] bsenha = null;

		Usuario usuario = new Usuario();
		usuario.setUsername(nome);
		
		senha = retornarValorCriptografado(senha);
		System.out.println(senha);
		usuario.setPassword(senha);
		
		UsuarioService service = new UsuarioService();
		
		if(service.validar(usuario)){
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			System.out.println("Logou "+usuario);
		} else {
			System.out.println("NÃ£o Logou "+usuario);
			throw new ServletException("UsuÃ¡rio/Senha invÃ¡lidos");
		}
		response.sendRedirect("index.jsp");
	}
	
	public String retornarValorCriptografado(String senha) {
		String sMsgClara = senha;
		String sMsgCifrada = null;
		byte[] bMsgClara = null;
		byte[] bMsgCifrada = null;
		// Instancia objeto da classe Impressora
		Impressora prn = new Impressora();
		// Imprime marcador de bloco
		System.out
				.println("-------------------------------------------------------------- -");
		// Imprime Texto
		System.out.println(">>> Imprimindo mensagem original...");
		System.out.println("");
		// Converte o texto String dado no equivalente byte[]
		try {
			bMsgClara = sMsgClara.getBytes("ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Imprime cabecalho da mensagem
		System.out.println("Mensagem Clara (Hexadecimal):");
		// Imprime o texto original em Hexadecimal
		System.out.print(prn.hexBytesToString(bMsgClara));
		System.out.println("");
		// Imprime o cabecalho da mensagem
		System.out.println("Mensagem Clara (String):");
		// Imprime o texto original em String
		System.out.println(sMsgClara);
		System.out.println("");
		
		///////////////////////////////////////////////////////////////////////////////
		// Imprime Texto
				System.out.println(">>> Cifrando com o algoritmo AES...");
				System.out.println("");
				// Instancia um objeto da classe CryptoAES
				CryptoAES caes = new CryptoAES();
				// Gera a Chave criptografica AES simetrica e o nome do arquivo onde
				// seraÌ� armazenada
				try {
					caes.geraChave(new File("chave.simetrica"));
				} catch (NoSuchAlgorithmException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (InvalidAlgorithmParameterException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (CertificateException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (KeyStoreException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// Gera a cifra AES da mensagem dada, com a chave simetrica dada
				try {
					caes.geraCifra(bMsgClara, new File("chave.simetrica"));
				} catch (InvalidKeyException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (NoSuchAlgorithmException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (NoSuchPaddingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IllegalBlockSizeException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (BadPaddingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (InvalidAlgorithmParameterException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} // Recebe o
																		// texto cifrado
				try {
					bMsgCifrada = caes.getTextoCifrado();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// Converte o texto byte[] no equivalente String
				try {
					sMsgCifrada = (new String(bMsgCifrada, "UTF-8"));
				} catch (UnsupportedEncodingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} // Imprime
																		
				prn.hexBytesToString(bMsgCifrada);
			
				String resultado = sMsgCifrada;
				
			
																			
			return resultado;
	}


}
