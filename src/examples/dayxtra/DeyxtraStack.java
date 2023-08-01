package examples.dayxtra;

import examples.Example;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeyxtraStack implements Example {
    private final Stack<String> operations;
    private final Stack<Double> values;
    private final Pattern OPERATORS_PATTERN;
    private final Pattern NUMBER_PATTERN;

    private final Pattern GROUP_MATCHER;

    public DeyxtraStack() {
        this.values = new Stack<>();
        this.operations = new Stack<>();

        this.OPERATORS_PATTERN = Pattern.compile("[+\\-*/]|sqrt");
        this.NUMBER_PATTERN = Pattern.compile("\\d");
        this.GROUP_MATCHER = Pattern.compile("[\\d.]+|[)(+\\-*/]|sqrt");
    }

    private Double calculate() {
        String operator = operations.pop();
        Double value = values.pop();

        return switch (operator) {
            case "+" -> values.pop() + value;
            case "-" -> values.pop() - value;
            case "*" -> values.pop() * value;
            case "/" -> values.pop() / value;
            case "sqrt" -> Math.sqrt(value);
            default -> values.pop();
        };
    }

    @Override
    public Double run(String argument) {
        Matcher charset = GROUP_MATCHER.matcher(argument);

        while (charset.find()) {
            String symbol = charset.group();
            boolean isContainOperator = OPERATORS_PATTERN
                    .matcher(symbol)
                    .find();
            boolean isContainNumber = NUMBER_PATTERN
                    .matcher(symbol)
                    .find();

            if (isContainOperator) {
                operations.push(symbol);
            } else if (symbol.equals(")")) {
                values.push(calculate());
            } else if (isContainNumber){
                values.push(Double.parseDouble(symbol));
            }

        }

        return values.pop();
    }
}
