package com.swan.ticket;

public class SequenceCodition implements DiscountCondition {
    private int sequence;

    public SequenceCodition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
