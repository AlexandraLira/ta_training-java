package com.epam.rd.autotasks.arithmeticexpressions;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        return new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if (value < 0) return "(" + value + ")";
                return String.valueOf(value);
            }
        };
    }

    public static Expression sum(Expression... members) {
        return new Expression() {
            @Override
            public int evaluate() {
                int resulSum = 0;
                for (Expression member : members) {
                    resulSum += member.evaluate();
                }
                return resulSum;
            }

            @Override
            public String toExpressionString() {
                StringBuilder expression = new StringBuilder("(");
                for (Expression member : members) {
                    expression.append(member.toExpressionString()).append(" + ");
                }
                expression.delete(expression.length() - 3, expression.length());
                expression.append(")");
                return expression.toString();
            }
        };
    }

    public static Expression product(Expression... members) {
        return new Expression() {
            @Override
            public int evaluate() {
                int multiplication = 1;
                for (Expression member : members) {
                    multiplication *= member.evaluate();
                }
                return multiplication;
            }

            @Override
            public String toExpressionString() {
                StringBuilder expression = new StringBuilder("(");
                for (Expression member : members) {
                    expression.append(member.toExpressionString()).append(" * ");
                }
                expression.delete(expression.length() - 3, expression.length());
                expression.append(")");
                return expression.toString();
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend) {
        return new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                String result = "(";
                result += minuend.toExpressionString() + " - ";
                result += subtrahend.toExpressionString() + ")";
                return result;
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor) {
        return new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                String result = "(";
                result += dividend.toExpressionString() + " / ";
                result += divisor.toExpressionString() + ")";
                return result;
            }
        };
    }

}
