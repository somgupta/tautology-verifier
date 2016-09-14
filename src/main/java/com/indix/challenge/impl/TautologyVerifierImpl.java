package com.indix.challenge.impl;

import com.indix.challenge.PropositionEvaluator;
import com.indix.challenge.TautologyVerifier;
import com.indix.challenge.dtos.Proposition;

import static com.indix.challenge.dtos.TruthValue.*;
import static com.indix.challenge.dtos.Operator.*;

import com.indix.challenge.dtos.Variable;
import com.indix.challenge.utils.PropositionStack;

/**
 * Created by somya.gupta on 13/09/16.
 */
public class TautologyVerifierImpl implements TautologyVerifier {

   private PropositionEvaluator propositionEvaluator;

   public TautologyVerifierImpl(PropositionEvaluator propositionEvaluator) {
      this.propositionEvaluator = propositionEvaluator;
   }

   @Override
   public boolean verify(Proposition p) {

      PropositionStack stack = new PropositionStack();

      for (char ch : p.getProposition()) {
         if (ch == ' ') {
            continue;
         }
         if (ch == ')') {
            stack.push(')');
            Proposition subProp = stack.getSubProposition();

            Variable subResult = propositionEvaluator.evaluate(subProp);

            if (subResult == null) {
               stack.push(F.getValue());
            } else {
               if (subResult.isNegated()) {
                  stack.push(NOT.getValue());
               }
               stack.push(subResult.getVariable());
            }
         } else
            stack.push(ch);
      }

      boolean result = false;
      if (stack.pop() == T.getValue() && stack.empty()) {
         result = true;
      }

      return result;
   }

}
