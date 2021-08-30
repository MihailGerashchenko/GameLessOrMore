package org.example;

import org.junit.AfterClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private Model model = new Model();

    @Test
    @DisplayName("For verifying value")
    void testToCheckSetSecretValueMethod() {

        for (int i = 0; i < 10000; i++) {
            model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER, GlobalConstants.PRIMARY_MAX_BARRIER);
            model.setSecretValue();
            int number = model.getSecretValue();
            Assertions.assertAll(() -> assertTrue(number > GlobalConstants.PRIMARY_MIN_BARRIER),
                    () -> assertTrue(number < GlobalConstants.PRIMARY_MAX_BARRIER));
        }
    }

    @Test
    @DisplayName("Work the margins out")
    void testToCheckSetPrimaryBarrierMethod() {
        assertTrue(model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER, GlobalConstants.PRIMARY_MAX_BARRIER));

    }

    @Test
    @DisplayName("This test runs provided signature int number is not secret value")
    void testToExamineCheckValueMethod() {
        assertTrue(model.checkValue(12));
    }
}