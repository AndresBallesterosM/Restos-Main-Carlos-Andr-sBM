package co.edu.taller.creational;

import java.util.*;

public class ExecutiveReport {

    private final String title;
    private final String period;
    private final List<String> sections;

    private ExecutiveReport(Builder b) {
        this.title = b.title;
        this.period = b.period;
        this.sections = List.copyOf(b.sections);
    }

    public String title() {
        return title;
    }

    public String period() {
        return period;
    }

    public List<String> sections() {
        return sections;
    }

    public static class Builder {

        private String title;
        private String period;
        private final List<String> sections = new ArrayList<>();

        public Builder title(String v) {
            this.title = v;
            return this;
        }

        public Builder period(String v) {
            this.period = v;
            return this;
        }

        public Builder addSection(String v) {
            sections.add(v);
            return this;
        }

        public ExecutiveReport build() {

            if (title == null || title.isBlank()) {
                throw new IllegalStateException("Title is required");
            }

            if (period == null || period.isBlank()) {
                throw new IllegalStateException("Period is required");
            }

            return new ExecutiveReport(this);
        }
    }
}