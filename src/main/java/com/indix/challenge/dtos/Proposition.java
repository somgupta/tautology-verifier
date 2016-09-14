package com.indix.challenge.dtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by somya.gupta on 13/09/16.
 */
public class Proposition {

   private List<Character> proposition;

   public Proposition(List<Character> proposition) {
      this.proposition = proposition;
   }

   public List<Character> getProposition() {
      return this.proposition;
   }
}
