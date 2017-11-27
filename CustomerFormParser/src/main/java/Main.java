/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.parboiled.Parboiled;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.common.StringUtils;
import static org.parboiled.support.ParseTreeUtils.printNodeTree;
import org.parboiled.support.ParsingResult;

import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        CustomerForm parser = Parboiled.createParser(CustomerForm.class);
        
        while (true) {
            System.out.print("Enter in an address(Street number street name city zip state(two letter) country name)\n");
            String input1 = new Scanner(System.in).nextLine();
            String input2 = new Scanner(System.in).nextLine();
            String input3 = new Scanner(System.in).nextLine();
            String input = input1 + '\n' + input2 + '\n' + input3 + '\n';
            if (StringUtils.isEmpty(input1)) break;

            ParsingResult<?> result = new RecoveringParseRunner(parser.InputLine()).run(input);
            
            System.out.println(input + " = " + result.parseTreeRoot.getValue() + '\n');
            System.out.println(printNodeTree(result) + '\n');

            if (!result.matched) {
                System.out.println(StringUtils.join(result.parseErrors, "---\n"));
            }
        }
    }

}

