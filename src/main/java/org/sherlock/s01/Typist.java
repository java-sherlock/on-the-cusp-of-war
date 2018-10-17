package org.sherlock.s01;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
//why this class is final and doesn't have interface?
// меня не подкупишь и на прокси не заменишь
@Component
public final class Typist {

    public String imprint(List<String> lines) {
        return lines.stream().skip(2).reduce((s, s2) -> s +"\n"+ s2).orElse("empty text");
    }
}
