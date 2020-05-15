/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorrmi01;

import RMIInterface.Numero;
import RMIInterface.Operacoes;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Yan
 */
public class ServidorRMI01  extends UnicastRemoteObject implements Operacoes{
    private static final long serialVersionUID = 0L;

    public ServidorRMI01() throws RemoteException{
        super();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Naming.rebind("//localhost/AlgoritmosNotaveis", new ServidorRMI01());
            System.out.println("Servidor Pronto");
        } catch (Exception e) {
            System.err.println("Exceção gerada: " + e.getMessage());
        }
    }

    @Override
    public double Pi(Numero n) throws RemoteException {
        return p(n.getN());
    }
    
    private double p(int n){
        double pi=1.;
        
        for(int i=1; i<n; i++)
            pi *= (2.*i)*(2.*i)/(2.*i-1.)/(2.*i+1.);
        
        return 2*pi;
    }

    @Override
    public int Fatorial(Numero n) throws RemoteException {
        return fat(n.getN());
    }
    
    private int fat(int n){
        if(n==0 || n==1) return n;
        return fat(n-1) + fat(n-2);
    }
    
}
