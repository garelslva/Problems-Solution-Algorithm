/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchstringkeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vinicius
 */
public class SearchStringKeys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      String strEvents = "ifaio=ejpo.fevento8=5423fofsnofsfpifp=ifnfevento1=1212fofsnofsfpifp="+
                            "ifnfevento2=5523fofsnofsfpifp=ejpo.fevento9=3891fofsnofsfpifp=ejpo.f"+
                            "evento3=2891fofsnofsfpifp=ifnfevento5=6212fofsnofsfpifp=ifnfevento7="+
                            "7212fofsnofsfpifp=ifnfevento6=0212fofsnofsfpifp=ifnfevento4=9212fofs"+
                            "nofsfpifp=ifnfevento0=2212";
      
      new PipeSearch(strEvents)
              /* obtemEvento(String entrada)
               *   Obtém uma lista do padrão eventoX=ABCD 
               *   sendo X = numero de 0 a 9 e 
               *   ABCD = numero de 4 digitos 
               */ 
              .loadEvent()
                 /* questaoA()
                 *   Ordena de modo crescente o padrão (eventoX=ABCD) 
                 *   de acordo o numero X do padrão
                 *   sendo X = numero de 0 a 9 e 
                 *   ABCD = numero de 4 digitos 
                 *   retorna uma Lista do resultado, 
                 *   se não retorna Lista vazia
                 */   
                .ascendentOrder()
                 /* questaoB()
                 *   Obtém o ABCD do padrão (eventoX=ABCD) 
                 *   sendo X = numero de 0 a 9 e 
                 *   ABCD = numero de 4 digitos 
                 *   se ABCD<6000 retorna uma lista do resultado, 
                 *   se não retorna Lista vazia
                 */
                .numbersLow6000()
                 /* questaoC()
                 *   Obtém o X do padrão eventoX=ABCD 
                 *   sendo X = numero de 0 a 9 e 
                 *   ABCD = numero de 4 digitos 
                 *   se X=1 retorna uma lista do resultado, 
                 *   se não retorna '!'
                 */
                .textQA()
              .showResults();      
    }
    
    static  class PipeSearch{

        private String inputEventsList;
        private List<String> unitEventList;
        private List<String> ordened;
        private List<String> low6000;
        private List<String> textQA;
        private PipeSearch pipeSearch;
        
        public PipeSearch(String events){
            this.inputEventsList = events;
        }

        public PipeSearch(String events, List<String> unitEventList){
            this.inputEventsList = events;
            this.unitEventList =  unitEventList;
        }

        public PipeSearch(String events, List<String> unitEventList, List<String> ordened){
            this(events, unitEventList);
            this.ordened =  ordened;
        }

        public PipeSearch(String events, List<String> unitEventList, List<String> ordened, List<String> low6000){
            this(events, unitEventList, ordened);
            this.low6000 = low6000;
        }

        public PipeSearch(String events, List<String> unitEventList, List<String> ordened, List<String> low6000, List<String> textQA){
            this(events, unitEventList, ordened, low6000);
            this.textQA = textQA;
        }
      
        private PipeSearch loadEvent() {
            unitEventList =  new ArrayList<>();
            Matcher  m = Pattern.compile("(evento\\d=\\d{1,4})").matcher( inputEventsList );
            while(m.find()) unitEventList.add( m.group() );
            return pipeSearch = new PipeSearch(inputEventsList, unitEventList);
        }

        private PipeSearch ascendentOrder() {
            ordened = unitEventList;
            Collections.sort(ordened);
            return pipeSearch = new PipeSearch(inputEventsList, unitEventList, ordened);
        }

        private PipeSearch numbersLow6000() {
            low6000 =  new ArrayList<>();
            for(String n : unitEventList)
             if(Integer.parseInt( n.replaceAll("(evento\\d=)(\\d{4})", "$2") ) < 6000) low6000.add(n);       
            return pipeSearch = new PipeSearch(inputEventsList, unitEventList, ordened, low6000);
        }

        private PipeSearch textQA() {
            textQA =  new ArrayList<>();
            for(String n : unitEventList) textQA.add((n.startsWith("evento1")?"Eu vou ser QA":"!"));
            return pipeSearch = new PipeSearch(inputEventsList, unitEventList, ordened, low6000, textQA);
        }

        private void showResults() {    
            System.out.println("Eventos Encontrados com chave X de 0 a 9:\n"+ unitEventList);
            System.out.println("\n\nQuestão A - retorna eventos em ordem Cresecente de acordo a chave X do evento\n"+ordened);
            System.out.println("\n\nQuestão B - retorna eventos de valores menores que 6000\n"+low6000);
            System.out.println("\n\nQuestão C - retorna 'Eu vou ser QA' quando a chave do evento for 1 e retorna '!' caso contrario\n"+textQA);
        }
        
    }
}
