/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIInterface;

import java.io.Serializable;

/**
 *
 * @author Yan
 */
public class Numero  implements Serializable{
    private static final long serialVersionUID = 3141592L;
    private int n;
    
    public Numero(int n){
        this.n = (n>=0)?n:0;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }
    
}
