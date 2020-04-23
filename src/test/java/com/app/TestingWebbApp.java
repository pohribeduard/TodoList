package com.app;
import com.app.controller.dashboard.UserDashboardController;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class TestingWebbApp {

    @Mock
    private UserDashboardController controller;

    @Test
    public void contexLoads() throws Exception {
        assert controller != null;
    }
}
