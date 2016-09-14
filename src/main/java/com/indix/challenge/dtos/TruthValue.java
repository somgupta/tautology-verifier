package com.indix.challenge.dtos;

/**
 * Created by somya.gupta on 13/09/16.
 */
public enum TruthValue {

   T('1'),
   F('0');

   private Character value;

   TruthValue(Character value) {

      this.value = value;
   }

   public Character getValue() {

      return value;
   }
}
