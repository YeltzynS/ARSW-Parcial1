/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arsw.blacklistvalidator;


import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.jvm.hotspot.runtime.Threads;

/**
 *
 * @author yeltzyn.sierra-a
 */
public class HostBlackThread extends Threads {
    LinkedList<Integer> blackListOcurrences=new LinkedList<>();
    int checkedListsCount= 0;
    int ocurrencesCount= 0;
    HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
    String ipaddress;
    int start,end;
    private static final int BLACK_LIST_ALARM_COUNT =2;
    
    
    
    
    public HostBlackThread(String ipaddress, int start, int end){
        this.ipaddress = ipaddress; this.start = start; this.end = end;
    }
    
    
    public void run(){
        for (int i = start; i< end && ocurrencesCount<BLACK_LIST_ALARM_COUNT;i++ ){
            checkedListsCount ++;
            if (skds.isInBlackListServer(i, ipaddress)){
                ocurrence(i);
            }
        }
        if (ocurrencesCount>=BLACK_LIST_ALARM_COUNT){
            skds.reportAsNotTrustworthy(ipaddress);
        }
        else{
            skds.reportAsTrustworthy(ipaddress);
        }                
        
        LOG.log(Level.INFO, "Checked Black Lists:{0} of {1}", new Object[]{checkedListsCount, skds.getRegisteredServersCount()});
        
        //return blackListOcurrences; 
    }
    
    
   
    
        
    

    private synchronized void ocurrence(int i) {
        blackListOcurrences.add(i);
        ocurrencesCount++;
    }

    private static final Logger LOG = Logger.getLogger(HostBlackListsValidator.class.getName());
}
