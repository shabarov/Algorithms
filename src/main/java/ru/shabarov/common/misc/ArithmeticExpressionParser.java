package ru.shabarov.common.misc;

import java.util.Stack;

public class ArithmeticExpressionParser {

    private static final char SEPARATOR = '_';

    public static void main(String[] args) {
        final ArithmeticExpressionParser parser = new ArithmeticExpressionParser();

        System.out.println(parser.evaluate("1 + 2 * 3 - 4")); //3
        System.out.println(parser.evaluate("(1 + 2) * 3 - 4")); //5
        System.out.println(parser.evaluate("(1+2)*(3-4*(3-2))")); //-3

        System.out.println(parser.evaluate("42+1")); //43
        System.out.println(parser.evaluate("5/2")); //2
        System.out.println(parser.evaluate("3 + 4"));//7
        System.out.println(parser.evaluate("6-4 / 4"));//5
        System.out.println(parser.evaluate("4*(5+5*2)/3+(6/2+9)"));//32
        System.out.println(parser.evaluate("(4+6* 3+9- (3*16/8+2)*5)+3"));//-6

        System.out.println(parser.evaluate("(5+6)*3-6*(1+6/2)"));//9
    }

    private Integer evaluate(String expression) {
        String postfix = infix2Postfix(expression);
        BinaryArithmeticTreeNode treeNode = postfix2Tree(postfix);
        Integer res = evalTree(treeNode);
        return res;
    }

    private String infix2Postfix(String expression) {
        final StringBuilder postfixExpression = new StringBuilder();
        final Stack<Operation> operations = new Stack<>();

        int idx = 0;
        int numStartIdx = -1;
        while (idx < expression.length()) {
            final char nextChar = expression.charAt(idx);
            if (Character.isDigit(nextChar)) {
                if (numStartIdx < 0) {
                    if (idx == expression.length() - 1) {
                        postfixExpression.append(expression, idx, idx + 1).append(SEPARATOR);
                    }
                    numStartIdx = idx;
                }
            } else {
                if (numStartIdx >= 0) {
                    postfixExpression.append(expression, numStartIdx, idx).append(SEPARATOR);
                    numStartIdx = -1;
                }
                if (!Character.isWhitespace(nextChar)) {
                    final Operation operation = Operation.of(String.valueOf(nextChar));
                    if (Operation.RIGHT_BRACE == operation) {
                        Operation prevOperation;
                        while ((prevOperation = operations.pop()) != Operation.LEFT_BRACE) {
                            postfixExpression.append(prevOperation.action);
                        }
                    } else {
                        if (!operations.isEmpty()) {
                            Operation prevOperation = operations.peek();
                            if (operation != Operation.LEFT_BRACE && prevOperation.priority > operation.priority) {
                                while (!operations.isEmpty() &&
                                        (prevOperation = operations.pop()) != Operation.LEFT_BRACE) {
                                    postfixExpression.append(prevOperation.action);
                                }
                                if (prevOperation == Operation.LEFT_BRACE) {
                                    operations.push(Operation.LEFT_BRACE);
                                }
                            }
                        }
                        operations.push(operation);
                    }
                }
            }
            idx++;
        }

        while (!operations.isEmpty()) {
            postfixExpression.append(operations.pop().action);
        }

        return postfixExpression.toString();
    }

    private BinaryArithmeticTreeNode postfix2Tree(String postfix) {
        Stack<BinaryArithmeticTreeNode> nodes = new Stack<>();
        int numStartIdx = -1;
        for (int i = 0; i < postfix.length(); i++) {
            char nextChar = postfix.charAt(i);
            if (Character.isDigit(nextChar)) {
                if (numStartIdx < 0) {
                    numStartIdx = i;
                }
            } else if (nextChar == SEPARATOR) {
                BinaryArithmeticTreeNode numNode = new BinaryArithmeticTreeNode();
                numNode.numValue = Integer.parseInt(postfix.substring(numStartIdx, i));
                numStartIdx = -1;
                nodes.push(numNode);
            } else {
                Operation oper = Operation.of(String.valueOf(nextChar));
                BinaryArithmeticTreeNode operNode = new BinaryArithmeticTreeNode();
                operNode.operation = oper;
                operNode.right = nodes.pop();
                operNode.left = nodes.pop();
                nodes.push(operNode);
            }
        }
        return nodes.pop();
    }

    private Integer evalTree(BinaryArithmeticTreeNode treeNode) {
        if (treeNode.numValue != null) {
            return treeNode.numValue;
        } else {
            switch (treeNode.operation) {
                case MINUS:
                    return evalTree(treeNode.left) - evalTree(treeNode.right);
                case PLUS:
                    return evalTree(treeNode.left) + evalTree(treeNode.right);
                case DIV:
                    return evalTree(treeNode.left) / evalTree(treeNode.right);
                case MULT:
                    return evalTree(treeNode.left) * evalTree(treeNode.right);
                default:
                    throw new IllegalStateException("Unknown operation");
            }
        }
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
        LEFT_BRACE("(", -1),
        RIGHT_BRACE(")", -2);

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
