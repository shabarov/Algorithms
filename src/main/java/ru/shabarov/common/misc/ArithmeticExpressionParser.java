package ru.shabarov.common.misc;

import java.util.Stack;

public class ArithmeticExpressionParser {

    public static void main(String[] args) {
        final ArithmeticExpressionParser parser = new ArithmeticExpressionParser();
        String result = parser.infix2Postfix("1 + 2 * 3 - 4");
        System.out.println("\"1 + 2 * 3 - 4\" = " + result);

        result = parser.infix2Postfix("(1 + 2) * 3 - 4");
        System.out.println("\"(1 + 2) * 3 - 4\" = " + result);
    }

    private String infix2Postfix(String expression) {
        final StringBuilder postfixExpression = new StringBuilder();
        final Stack<Operation> operations = new Stack<>();

        int idx = 0;
        while (idx < expression.length()) {
            final char nextChar = expression.charAt(idx++);
            if (Character.isDigit(nextChar)) {
                postfixExpression.append(nextChar);
            } else if (!Character.isWhitespace(nextChar)) {
                final Operation operation = Operation.of(String.valueOf(nextChar));
                if (Operation.RIGHT_BRACE == operation) {
                    Operation prevOperation = null;
                    while ((prevOperation = operations.pop()) != Operation.LEFT_BRACE) {
                        postfixExpression.append(prevOperation.action);
                    }
                } else {
                    if (!operations.isEmpty()) {
                        Operation prevOperation = operations.peek();
                        if (prevOperation.priority > operation.priority) {
                            prevOperation = operations.pop();
                            while (prevOperation != Operation.LEFT_BRACE && !operations.isEmpty()) {
                                postfixExpression.append(prevOperation.action);
                                prevOperation = operations.pop();
                            }
                            postfixExpression.append(prevOperation.action);
                        }
                    }
                    operations.push(operation);
                }
            }
        }

        for (Operation operation : operations) {
            postfixExpression.append(operation.action);
        }

        return postfixExpression.toString();
    }

    static class BinaryArithmeticTreeNode {
        Operation operation;
        Integer numValue;
        BinaryArithmeticTreeNode left;
        BinaryArithmeticTreeNode right;
    }

    enum Operation {

        PLUS("+", 0),
        MINUS("-", 1),
        MULT("*", 2),
        DIV("/", 3),
        LEFT_BRACE("(", 4),
        RIGHT_BRACE(")", 5);

        String action;
        int priority;

        Operation(String action, int priority) {
            this.action = action;
            this.priority = priority;
        }

        public static Operation of(String stringOperation) {
            for (Operation operation : Operation.values()) {
                if (operation.action.equals(stringOperation)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Unknown operation");
        }
    }

}
