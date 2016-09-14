package com.indix.challenge.dtos;

/**
 * Created by somya.gupta on 13/09/16.
 */
public class Variable {

   private Character ch;
   private boolean negated;

   public Character getVariable() {
      return this.ch;
   }

   public void setNegatedVariable(Character ch) {
      this.ch = ch;
      this.negated = true;
   }

   public void setVariable(Character ch) {
      this.ch = ch;
      this.negated = false;
   }

   public boolean isNegated() {
      return this.negated;
   }
}
