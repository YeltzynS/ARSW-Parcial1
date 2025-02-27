/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arsw.blacklistvalidator;


import java.util.LinkedList;
import sun.jvm.hotspot.runtime.Threads;

/**
 *
 * @author yeltzyn.sierra-a
 */
public class HostBlackThread extends Threads {
    private LinkedList<Integer> blackListOcurrences=new LinkedList<>();
    int checkedListsCount=0;
    int count=0;
    
    public HostBlackThread(int checkedListsCount, LinkedList<Integer> blackListOcurrences, int count){
        
    }
 
    public void run(){
        
        }
        
    
 
}
