package dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AFD {
	private static List<String> listaestados;
	private static String inicial;
	private static List<String> listaestadosfinais;
	private static List<String> listaalfabeto;
	private static List<String> listadetransicoes;
	
	public static void main(String[] args) {
		lerAfd();
	}

	public static void lerAfd() {
		try {
			File afd = new File("afd.txt");
			Reader in = new FileReader(afd);
			LineNumberReader reader = new LineNumberReader(in);
			

			listaestados = new ArrayList<String>();
			String[] vetorestados = reader.readLine().replace("E: ", " ").trim()
					.split(" ");
			listaestados = Arrays.asList(vetorestados);
			inicial = reader.readLine().replace("i: ", "");
			listaestadosfinais = new ArrayList<String>();
			String[] vetorestadosfinais = reader.readLine().replace("F: ", "").trim()
					.split(" ");
			listaestadosfinais = Arrays.asList(vetorestadosfinais);

			listaalfabeto = new ArrayList<String>();
			String[] vetoralfabeto = reader.readLine().replace("AB: ", "").trim()
					.split(" ");
			listaalfabeto = Arrays.asList(vetoralfabeto);
			listadetransicoes = new ArrayList<String>();
			
			listadetransicoes = ListaTransicoes(reader);

			
			for (String s : listaalfabeto) { 
				System.out.println("ALFABETO");
				System.out.println(s);
			}
			
			for (String s : listaestados) {
				System.out.println("ESTADOS");
				System.out.println(s);
			}

			for (String s : listaestadosfinais) { 
				System.out.println("FINAIS");
				System.out.println(s);
			}
			
			for (String s : listadetransicoes) { 
				System.out.println("TRANSICOES");
				System.out.println(s);
			}
			
			System.out.println("INICIAL");			
			System.out.println(inicial);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	
	private static List<String> ListaTransicoes(LineNumberReader arquivo)
    {
        int fim = 0;
        List<String> transicoes = new ArrayList<String>();

        while (fim == 0)
        {
            String transicao = null;
			try {
				transicao = arquivo.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

            if (transicao != null)
            {
                transicoes.add(transicao.trim());
            }
            else
            {
                fim = 1;
            }
        }

        return transicoes;
    }

}
