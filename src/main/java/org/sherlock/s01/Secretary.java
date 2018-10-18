package org.sherlock.s01;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Evgeny Borisov
 */
@Component
@RequiredArgsConstructor
//why this class is final and doesn't have interface?
// меня не подкупишь и на прокси не заменишь
public final class Secretary {
    private final Typist typist;
    private final РrintеrStation printer;

    @Scheduled(fixedDelay = 100000)
    @SneakyThrows
    public void handle() {
        List<String> lines = Files.lines(Paths.get("postbox/envelop.txt")).collect(Collectors.toList());
        String text = typist.imprint(lines);
        Order order = Order.builder().title(lines.get(0)).amount(Integer.parseInt(lines.get(1))).body(text).build();
        printer.print(order);
    }
}










