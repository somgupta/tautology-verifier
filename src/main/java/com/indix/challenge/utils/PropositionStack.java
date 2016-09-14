package com.indix.challenge.utils;

import com.indix.challenge.dtos.Proposition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by somya.gupta on 13/09/16.
 */
public class PropositionStack {

   private Stack<Character> stack;

   public PropositionStack() {
      this.stack = new Stack<>();
   }
   public void push(Character ch) {
      stack.push(ch);
   }

   public Character pop() {
      return this.stack.pop();
   }

   public boolean empty() {
      return this.stack.empty();
   }

   public Character peek() {
      return this.stack.peek();
   }

   public Proposition getSubProposition() {
      List<Character> subProp = new ArrayList<>();

      Character ch = this.stack.pop();
      while (ch != '(') {
         subProp.add(ch);
         ch = this.stack.pop();
      }
      subProp.add('(');

      Collections.reverse(subProp);

      return new Proposition(subProp);
   }
}
