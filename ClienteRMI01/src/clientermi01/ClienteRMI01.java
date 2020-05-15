/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientermi01;

import RMIInterface.Numero;
import RMIInterface.Operacoes;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.NoSuchElementException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Yan
 */
public class ClienteRMI01 {
    private static Operacoes look_up;
    
    /**
     * @param args the command line arguments
     * @throws java.rmi.NotBoundException
     * @throws java.net.MalformedURLException
     * @throws java.rmi.RemoteException
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        look_up = (Operacoes) Naming.lookup("//localhost/AlgoritmosNotaveis");
        
        boolean denovo;
		do{
			String[] options = {"Fatorial", "Pi", "Sair"};
                        Icon imagem = new ImageIcon("./src/logo.jpg");
			int escolha = JOptionPane.showOptionDialog(null, "Escolha uma Operação", "Algorimos Notáveis", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, imagem, options, options[0]);
			
			switch(escolha){
				case 0:
					Integer n = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe n:", "Fatorial", JOptionPane.PLAIN_MESSAGE));
					try{
						int fatorial = look_up.Fatorial(new Numero(n));
                                                imagem = new ImageIcon("./src/fat.png");
						JOptionPane.showMessageDialog(null, "Cálculo do fatorial de " + n + " vale " + String.valueOf(fatorial), "Resultado", JOptionPane.INFORMATION_MESSAGE, imagem);
					}catch(NoSuchElementException ex){
						JOptionPane.showMessageDialog(null, "Erro no processamento");
					}
					break;
				case 1:
					n = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe n:", "Cálculo Pi", JOptionPane.PLAIN_MESSAGE));
					try{
						double pi = look_up.Pi(new Numero(n));
                                                imagem = new ImageIcon("./src/pi.png");
						JOptionPane.showMessageDialog(null, "O valor de PI na aproximação com " + n + " vale " + String.valueOf(pi), "Resultado", JOptionPane.INFORMATION_MESSAGE, imagem);
					}catch(NoSuchElementException ex){
						JOptionPane.showMessageDialog(null, "Erro no processamento");
					}
					break;
				default:
					System.exit(0);
					break;
			}
                        imagem = new ImageIcon("./src/logo.jpg");
			denovo = (JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.NO_OPTION);
		}while(denovo);
    }
    
}
