import java.util.*;
public class polishNotation
{   
    char[] ops = {'+', '-', '*', '/'};
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        ArrayList<String> operands = new ArrayList();
        String result;
        System.out.println("Operand'ları ve operatorleri birer boşluk bırakarak giriniz!\n");
        System.out.println("Operand ve operator sayıları Polish Notation kurallarına göre girilmelidir.\n");

        while(true)
        {           
             result = scn.nextLine();
             if(result == "-1")
               break;
             else
               operands.add(result);
        }
        polishNotation notatione = new polishNotation();
        System.out.println("Polish notasyonuna göre girdiğiniz işlemin sonucu: " + notatione.calculatePolishNotation(operands));
        scn.close();
    }
    public int calculatePolishNotation(ArrayList<String> notation) // Prefix girilen String değerini Postfix convert ederek hesaplıyor, daha kolay kodlanması açısından String reverse edildi.
    {
         
                ArrayList<String> aList = new ArrayList();
                for(int i = notation.size()-1; i >= 0; i--)
                {
                    if(notation.get(i) == " ") continue;
                    boolean flag = true;
                    for(char opr : this.ops)
                    {         
                        
                        if(notation.get(i).equals(opr))
                        {
                            if(opr == '+')
                            {            
                                String result = String.valueOf(Integer.parseInt(aList.get(aList.size()-1)) + Integer.parseInt(aList.get(aList.size()-2)));
                                aList.remove(aList.size()-1);
                                aList.remove(aList.size()-2);
                                aList.add(result); 
                                flag = false;
                                  
                            }
                            else if(opr == '-')
                            {
                                String result = String.valueOf(Integer.parseInt(aList.get(aList.size()-1)) - Integer.parseInt(aList.get(aList.size()-2)));
                                aList.remove(aList.size()-1);
                                aList.remove(aList.size()-2);
                                aList.add(result); 
                                flag = false;
                            }
                            else if(opr == '*')
                            {
                                String result = String.valueOf(Integer.parseInt(aList.get(aList.size()-1)) * Integer.parseInt(aList.get(aList.size()-2)));
                                aList.remove(aList.size()-1);
                                aList.remove(aList.size()-2);
                                aList.add(result); 
                                flag = false;
                            }
                            else if(opr == '/')
                            {
                                String result = String.valueOf(Integer.parseInt(aList.get(aList.size()-1)) / Integer.parseInt(aList.get(aList.size()-2)));
                                aList.remove(aList.size()-1);
                                aList.remove(aList.size()-2);
                                aList.add(result); 
                                flag = false;
                            }   
                        }
                    
                    }
                    if(flag) aList.add(notation.get(i));
                        
                }
    
            return Integer.parseInt(aList.get(aList.size()-1));
    }
}
