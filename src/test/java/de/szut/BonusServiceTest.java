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
}
