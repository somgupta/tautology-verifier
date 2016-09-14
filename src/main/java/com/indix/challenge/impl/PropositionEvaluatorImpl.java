package com.indix.challenge.impl;

import com.indix.challenge.dtos.Variable;
import com.indix.challenge.dtos.Proposition;
import static com.indix.challenge.dtos.TruthValue.*;
import static com.indix.challenge.dtos.Operator.*;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by somya.gupta on 13/09/16.
 */
public class PropositionEvaluatorImpl implements com.indix.challenge.PropositionEvaluator {

   private static Stack stack = new Stack();
   private static Variable result = new Variable();
   private static Iterator iter;

   @Override
   public Variable evaluate(Proposition prop) {

      iter = prop.getProposition().iterator();
      while (iter.hasNext()) {
         Character ch = (Character) iter.next();
         if (ch == ')') {
            break;
         } else if (ch == OR.getValue()) {
            orEvaluator();
         } else if (ch == AND.getValue()) {
            andEvaluator();
         } else
            stack.push(ch);
      }

      if ((Character) stack.pop() != '(') {
         result.setVariable(F.getValue());
      }

      return result;
   }

   // Since other solution was to add Truth Table for evaluation, for the purpose of completing the challenge in
   // lesser time, implementation is done in this way.

   // Evaluate OR Proposition
   private void orEvaluator() {
      Character prevCh = (Character) stack.pop();
      Character ch = (Character) iter.next();

      if(prevCh == T.getValue()) {
         if(!stack.empty() && stack.peek() == NOT.getValue()) {
            stack.pop();
            if(ch == NOT.getValue()) {
               result.setNegatedVariable((Character) iter.next());
            }
            else
               result.setVariable(ch);
         }
         else
            result.setVariable(T.getValue());
      }
      else if(prevCh == F.getValue()) {
         if(!stack.empty() && stack.peek() == NOT.getValue()) {
            stack.pop();
            result.setVariable(T.getValue());
         }
         else {
            if(ch == NOT.getValue()) {
               result.setNegatedVariable((Character) iter.next());
            }
            else
               result.setVariable(ch);
         }
      }

      if(ch == NOT.getValue()) {
         ch = (Character) iter.next();
         if(!stack.empty() && stack.peek() == NOT.getValue()) {
            stack.pop();
            if(prevCh == ch) {
               result.setNegatedVariable(ch);
            }
            else if(ch == T.getValue()) {
               result.setNegatedVariable(prevCh);
            }
         } else if (prevCh == ch) {
            result.setVariable(T.getValue());
         } else if (ch == F.getValue()) {
            result.setVariable(T.getValue());
         } else if (ch == T.getValue()) {
            result.setVariable(prevCh);
         }
      }
      else if (!stack.empty() && stack.peek() == NOT.getValue()) {
         stack.pop();
         if (prevCh == ch) {
            result.setVariable(T.getValue());
         } else if (prevCh == F.getValue()) {
            result.setVariable(T.getValue());
         } else if (prevCh == T.getValue()) {
            result.setVariable(F.getValue());
         } else if(ch == T.getValue()) {
            result.setVariable(T.getValue());
         } else if(ch == F.getValue()) {
            result.setNegatedVariable(prevCh);
         }
      } else if (ch == T.getValue() || prevCh == T.getValue()) {
         result.setVariable(T.getValue());
      } else if(ch == F.getValue()) {
         result.setVariable(prevCh);
      } else if(prevCh == F.getValue()){
         result.setVariable(ch);
      } else if(prevCh == ch) {
         result.setVariable(ch);
      } else {
         result.setVariable(F.getValue());
      }
   }

   // Evaluate AND Proposition
   private void andEvaluator() {
      Character prevCh = (Character) stack.pop();
      Character ch = (Character) iter.next();

      if(prevCh == T.getValue()) {
         if(!stack.empty() && stack.peek() == NOT.getValue()) {
            stack.pop();
            result.setVariable(F.getValue());
         }
         else {
            if(ch == NOT.getValue()) {
               result.setNegatedVariable((Character) iter.next());
            }
            else
               result.setVariable(ch);
         }
      }
      else if(prevCh == F.getValue()) {
         if (!stack.empty() && stack.peek() == NOT.getValue()) {
            stack.pop();
            if (ch == NOT.getValue()) {
               result.setNegatedVariable((Character) iter.next());
            } else
               result.setVariable(ch);
         } else {
            result.setVariable(F.getValue());
         }
      }

      if(ch == NOT.getValue()) {
         ch = (Character) iter.next();
         if(!stack.empty() && stack.peek() == NOT.getValue()) {
            stack.pop();
            if(prevCh == ch) {
               result.setVariable(ch);
            } else if(ch == F.getValue()) {
               result.setNegatedVariable(prevCh);
            }
         } else if (prevCh == ch) {
            result.setVariable(F.getValue());
         } else if (ch == T.getValue()) {
            result.setVariable(F.getValue());
         } else if (ch == F.getValue()) {
            result.setVariable(prevCh);
         } else {
            result.setVariable(F.getValue());
         }
      }
      else if (!stack.empty() && stack.peek() == NOT.getValue()) {
         stack.pop();
         if (prevCh == ch) {
            result.setVariable(F.getValue());
         } else if (prevCh == F.getValue()) {
            result.setVariable(ch);
         } else if (prevCh == T.getValue()) {
            result.setVariable(F.getValue());
         } else if(ch == F.getValue()) {
            result.setVariable(F.getValue());
         } else if(ch == T.getValue()) {
            result.setNegatedVariable(prevCh);
         }
      } else if (ch == F.getValue() || prevCh == F.getValue()) {
         result.setVariable(F.getValue());
      } else if(ch == T.getValue()) {
         result.setVariable(prevCh);
      } else if(prevCh == T.getValue()){
         result.setVariable(ch);
      } else if(prevCh == ch) {
         result.setVariable(ch);
      } else {
         result.setVariable(F.getValue());
      }
   }
}
