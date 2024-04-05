package ru.greatstep.virtualthreadsdbtest.config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RunAfterStartup {

    private final Logger logger = Logger.getLogger("RunAfterStartup");

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() throws IOException {
        try (InputStream inputStream =
                URI.create("http://localhost:8080/getOrders?code=client_1").toURL().openStream()) {
            logger.info(new String(inputStream.readAllBytes()));
        }
    }

}
