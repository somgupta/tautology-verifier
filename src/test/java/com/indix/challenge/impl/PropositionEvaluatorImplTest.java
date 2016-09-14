package com.indix.challenge.impl;

import com.indix.challenge.PropositionEvaluator;
import com.indix.challenge.dtos.Proposition;
import com.indix.challenge.dtos.Variable;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Created by somya.gupta on 14/09/16.
 */
public class PropositionEvaluatorImplTest {

   private PropositionEvaluator propositionEvaluator;

   @Before
   public void setUp() throws Exception {
      propositionEvaluator = new PropositionEvaluatorImpl();
   }

   @Test
   public void shouldEvaluateProposition() throws Exception {

      Variable result = new Variable();
      result.setVariable('a');

      Proposition p = new Proposition(Arrays.asList('(', 'a', '&', '1', ')'));

      assertReflectionEquals(propositionEvaluator.evaluate(p), result);
   }

}