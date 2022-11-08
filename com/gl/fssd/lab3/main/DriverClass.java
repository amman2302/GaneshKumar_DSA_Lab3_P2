package com.gl.fssd.lab3.main;
import java.util.Scanner;
import java.util.Set;

import com.gl.fssd.lab3.algo.*;

public class DriverClass {
    public static void main(String[] strArg)
    {
         try{
            SearchSumInBST oSearchSumInBST = new SearchSumInBST(40);
            oSearchSumInBST.insert(20);
            oSearchSumInBST.insert(10);
            oSearchSumInBST.insert(30);
            oSearchSumInBST.insert(60);
            oSearchSumInBST.insert(50);
            oSearchSumInBST.insert(70);
            System.out.println("Enter the sum  to find the pair in the given BST ");
            Scanner sc = new Scanner(System.in);
            int iNumber = sc.nextInt();
            sc.close();
            Set<Integer> foundPari = oSearchSumInBST.findSumPair(iNumber);

            if(foundPari.isEmpty()){
                System.out.println("Pairs are not found.");
            }else{
                System.out.println("Pairs are"+foundPari);
            }//End of else block
        }catch(Exception oException){
            System.out.println("Exception occured "+oException.getMessage());
        }//End of try-catch block  
    }//End of main method
}//End of DriverClass