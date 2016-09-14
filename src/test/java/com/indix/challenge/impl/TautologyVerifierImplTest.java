package com.indix.challenge.impl;

import com.indix.challenge.TautologyVerifier;
import com.indix.challenge.dtos.Proposition;
import com.indix.challenge.dtos.Variable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.indix.challenge.dtos.TruthValue.T;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by somya.gupta on 14/09/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class TautologyVerifierImplTest {

   @Mock
   private static PropositionEvaluatorImpl propositionEvaluator;

   private TautologyVerifier tautologyVerifier;

   @Before
   public void setUp() throws Exception {
      tautologyVerifier = new TautologyVerifierImpl(propositionEvaluator);
   }

   @Test
   public void shouldVerifyIfTautology() throws Exception {

      List<Character> list = Arrays.asList('(', '!', 'a', '|', 'a', ')');
      Proposition p = new Proposition(list);
      Variable var = new Variable();
      var.setVariable(T.getValue());

      when(propositionEvaluator.evaluate(any(Proposition.class))).thenReturn(var);
      assertThat(tautologyVerifier.verify(p), is(true));
   }

}