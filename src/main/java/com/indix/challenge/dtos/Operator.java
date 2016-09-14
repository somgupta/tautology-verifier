package com.indix.challenge.dtos;

/**
 * Created by somya.gupta on 14/09/16.
 */
public enum Operator {

   OR('|'),
   AND('&'),
   NOT('!');

   private Character value;

   Operator(Character value) {

      this.value = value;
   }

   public Character getValue() {

      return value;
   }
}
