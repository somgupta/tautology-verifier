package com.indix.challenge;

import com.indix.challenge.dtos.Proposition;
import com.indix.challenge.impl.PropositionEvaluatorImpl;
import com.indix.challenge.impl.TautologyVerifierImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * Created by somya.gupta on 14/09/16.
 */
public class ChallengeExecuter {

   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

      // Take input from console
      System.out.println("\n\nEnter number of propositions to add:");
      int numProps = parseInt(scanner.nextLine());

      System.out.println("\n\nEnter propositions:");
      System.out.println("\n------------------:");
      String[] propositions = new String[numProps];
      int i = 0;
      while (i < numProps) {
         propositions[i] = scanner.nextLine();
         i++;
      }

      // Verify and print result to console
      System.out.println("\nResults are:");
      System.out.println("\n------------------:");
      Boolean[] results = new Boolean[numProps];
      i = 0;
      for (String props : propositions) {

         List<Character> list = new ArrayList<>();
         for (char p : props.toCharArray()) {
            list.add(p);
         }

         Proposition p = new Proposition(list);
         PropositionEvaluator propositionEvaluator = new PropositionEvaluatorImpl();
         TautologyVerifier tautologyVerifier = new TautologyVerifierImpl(propositionEvaluator);
         results[i] = tautologyVerifier.verify(p);
         System.out.println(results[i]);
         i++;
      }
   }
}
