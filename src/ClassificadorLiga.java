import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ClassificadorLiga {

	public static void main(String[] args) 
	{
		String caminhoArquivo = "C:\\Users\\Aline\\Documents\\Unisinos\\Estruturas Avançadas de Dados II\\TGA\\E0.csv";
        if(args.length > 0)
            caminhoArquivo = args[0];
        try{
         File arquivo = new File(caminhoArquivo);
        
        String linhaArquivo;
        
        FileReader arquivoFileReader = new FileReader(arquivo);
        BufferedReader bufferArq = new BufferedReader(arquivoFileReader);
         while ((linhaArquivo = bufferArq.readLine()) != null) 
         {
             String[] camposLinha = linhaArquivo.split(",");
             System.out.println(camposLinha[0]);
             System.out.println(camposLinha[1]);
             System.out.println(camposLinha[2]);
             System.out.println(camposLinha[3]);
             System.out.println(camposLinha[4]);
             System.out.println(camposLinha[5]);
         }
        }catch(IOException excep){
            System.out.println("Problema ao ler arquivo "+ caminhoArquivo +". "+ excep.getMessage());
        }
	}

}
