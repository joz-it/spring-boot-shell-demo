package com.ag04.clidemo.config;

import com.ag04.clidemo.shell.InputReader;
import com.ag04.clidemo.shell.PromptColor;
import com.ag04.clidemo.shell.ShellHelper;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.Parser;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;


@Configuration
public class SpringShellConfig {

    @Bean
    public ShellHelper shellHelper(@Lazy LineReader lineReader) {
            return new ShellHelper(lineReader);
    }

    @Bean
    public InputReader inputReader(@Lazy LineReader lineReader) {
        return new InputReader(lineReader, this.shellHelper(lineReader));
    }

    /*
    @Bean
    public InputReader inputReader(@Lazy Terminal terminal, @Lazy Parser parser) {
        LineReaderBuilder lineReaderBuilder = LineReaderBuilder.builder().terminal(terminal).highlighter(
            (LineReader reader, String buffer) -> {
                return new AttributedString(
                    buffer, AttributedStyle.BOLD.foreground(PromptColor.WHITE.toJlineAttributedStyle())
                );
            }
        ).parser(parser);

        LineReader lineReader = lineReaderBuilder.build();
        lineReader.unsetOpt(LineReader.Option.INSERT_TAB);
        return new InputReader(lineReader);
    }*/

}