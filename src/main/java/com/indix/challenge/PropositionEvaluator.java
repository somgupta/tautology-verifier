package com.indix.challenge;

import com.indix.challenge.dtos.Proposition;
import com.indix.challenge.dtos.Variable;

/**
 * Created by somya.gupta on 14/09/16.
 */
public interface PropositionEvaluator {

   Variable evaluate(Proposition prop);
}
