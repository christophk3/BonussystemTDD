package de.szut;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BonusServiceTest {

    @Test
    void applyRestrictions_returnsMinBonus_whenBonusIsBelowMin() {
        BonusService service = new BonusService(0.0, 5000.0);

        double result = service.applyRestrictions(-10.0);

        assertThat(result).isEqualTo(0.0);
    }

    @Test
    void applyRestrictions_returnsMaxBonus_whenBonusIsAboveMax() {
        BonusService service = new BonusService(0.0, 5000.0);

        double result = service.applyRestrictions(6000.0);

        assertThat(result).isEqualTo(5000.0);
    }

    @Test
    void applyRestrictions_returnsBonusUnchanged_whenWithinRange() {
        BonusService service = new BonusService(0.0, 5000.0);

        double result = service.applyRestrictions(1234.56);

        assertThat(result).isEqualTo(1234.56);
    }

}
