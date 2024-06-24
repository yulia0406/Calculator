import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.*;

public class Forms extends JFrame
{
    JFrame jFrame = new JFrame("Calculator");
    JTextField jTextField = new JTextField(14);
    JButton addjb, subtractjb, divjb, multjb, dotjb, equalsjb, clearjb, deletejb, sqrtjb, powjb;
    JButton[] numbers = new JButton[10];
    String current, operator, previous, dop;
    boolean flagPow = false;
    boolean flagMult = false;
    boolean flagDiv = false;
   // boolean flagSub = false;
    public Forms()
    {
        current = "";
        previous = "";
        dop = "";
        //st_operator = "";
       addjb = new JButton("+");
       addjb.setPreferredSize(new Dimension(55, 55));
       subtractjb = new JButton("-");
       subtractjb.setPreferredSize(new Dimension(55, 55));
       divjb = new JButton("/");
        divjb.setPreferredSize(new Dimension(55, 55));
       multjb = new JButton("*");
        multjb.setPreferredSize(new Dimension(55, 55));
       dotjb = new JButton(".");
        dotjb.setPreferredSize(new Dimension(55, 55));
       equalsjb = new JButton("=");
        equalsjb.setPreferredSize(new Dimension(55, 55));
       clearjb = new JButton("AC");
        clearjb.setPreferredSize(new Dimension(55, 55));
       deletejb = new JButton("←");
        deletejb.setPreferredSize(new Dimension(55, 55));
       sqrtjb = new JButton("√");
        sqrtjb.setPreferredSize(new Dimension(55, 55));
       powjb = new JButton("^");
        powjb.setPreferredSize(new Dimension(55, 55));
        NumberBtnHandler numBtnHandler = new NumberBtnHandler();
        OtherBtnHandler otherBtnHandler = new OtherBtnHandler();
        OperatorBtnHandler opBtnHandler = new OperatorBtnHandler();
        for(int i = 0; i < numbers.length; i++)
        {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].setFont(new Font("Monospaced", Font.BOLD, 22));
            numbers[i].setPreferredSize(new Dimension(55, 55));
            numbers[i].addActionListener(numBtnHandler);
        }
        addjb.setFont(new Font("Monospaced", Font.BOLD, 22));
        addjb.addActionListener(opBtnHandler);
        subtractjb.setFont(new Font("Monospaced", Font.BOLD, 22));
        subtractjb.addActionListener(opBtnHandler);
        divjb.setFont(new Font("Monospaced", Font.BOLD, 22));
        divjb.addActionListener(opBtnHandler);
        multjb.setFont(new Font("Monospaced", Font.BOLD, 22));
        multjb.addActionListener(opBtnHandler);
        dotjb.setFont(new Font("Monospaced", Font.BOLD, 22));
        dotjb.addActionListener(numBtnHandler);
        equalsjb.setFont(new Font("Monospaced", Font.BOLD, 22));
        equalsjb.addActionListener(otherBtnHandler);
        clearjb.setFont(new Font("Monospaced", Font.BOLD, 18));
        clearjb.addActionListener(otherBtnHandler);
        deletejb.setFont(new Font("Monospaced", Font.BOLD, 22));
        deletejb.addActionListener(otherBtnHandler);
        sqrtjb.setFont(new Font("Monospaced", Font.BOLD, 22));
        sqrtjb.addActionListener(opBtnHandler);
        powjb.setFont(new Font("Monospaced", Font.BOLD, 22));
        powjb.addActionListener(opBtnHandler);

        jTextField.setMaximumSize(new Dimension(185, 40));
        jTextField.setFont(new Font("Monospaced", Font.BOLD, 27));
        jTextField.setDisabledTextColor(new Color(0, 0, 0));
        jTextField.setMargin(new Insets(0, 5, 0, 0));
        jTextField.setText("0");
        jTextField.setHorizontalAlignment(JTextField.RIGHT);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.setSize(260,385);

        jFrame.add(jTextField);
        jFrame.add(powjb);
        jFrame.add(sqrtjb);
        jFrame.add(divjb);
        jFrame.add(deletejb);
        jFrame.add(numbers[7]);
        jFrame.add(numbers[8]);
        jFrame.add(numbers[9]);
        jFrame.add(clearjb);
        jFrame.add(numbers[4]);
        jFrame.add(numbers[5]);
        jFrame.add(numbers[6]);
        jFrame.add(multjb);
        jFrame.add(numbers[1]);
        jFrame.add(numbers[2]);
        jFrame.add(numbers[3]);
        jFrame.add(subtractjb);
        jFrame.add(numbers[0]);
        jFrame.add(dotjb);
        jFrame.add(addjb);
        jFrame.add(equalsjb);
        jTextField.setEditable(false);
        jTextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                switch (e.getKeyChar())
                {
                    case '1' -> numbers[1].doClick();
                    case '2' -> numbers[2].doClick();
                    case '3' -> numbers[3].doClick();
                    case '4' -> numbers[4].doClick();
                    case '5' -> numbers[5].doClick();
                    case '6' -> numbers[6].doClick();
                    case '7' -> numbers[7].doClick();
                    case '8' -> numbers[8].doClick();
                    case '9' -> numbers[9].doClick();
                    case '0' -> numbers[0].doClick();
                    case '-' -> subtractjb.doClick();
                    case '+' -> addjb.doClick();
                    case '*' -> multjb.doClick();
                    case '/' -> divjb.doClick();
                    case KeyEvent.VK_ENTER -> equalsjb.doClick();
                    case '^' -> powjb.doClick();
                    case '.' -> dotjb.doClick();
                    case 's' -> sqrtjb.doClick();
                    case KeyEvent.VK_BACK_SPACE -> deletejb.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {}

            @Override
            public void keyTyped(KeyEvent e)
            {}

        });

    }

    public void delete()
    {
        if (current.length() > 0)
        {
            current = current.substring(0, current.length() - 1);
        }
    }

    public void clear()
    {
        current = "";
        previous = "";
        operator = null;
    }

    public void updateOutput()
    {
        jTextField.setText(current);
    }

    public void updateOutput2()
    {
        jTextField.setText(dop);
    }


    public void appendToOutput(String num) {
        if (num.equals(".") && current.contains(".")) {
            return;
        }
        current += num;
    }

    public void processOutputNumber() {
        if (current.length() > 0) {
            MathContext context = new MathContext(8, RoundingMode.HALF_UP);
            BigDecimal result = new BigDecimal(current, context);
            current = result.toString();
            String integerPart = current.split("\\.")[0];
            String decimalPart = current.split("\\.")[1];
            if (decimalPart.equals("0")) {
                current = integerPart;
            }
        }
    }

    public void selectOperator(String newOperator)
    {
        if (current.isEmpty()) {
            if(newOperator.equals("-"))
            {
                current = newOperator;
               // flagSub = true;
            }
            //st_operator = newOperator;
            dop = newOperator;
            return;
        }



        if (!previous.isEmpty()) {
            calculate();
        }

        dop = current;
        operator = newOperator;
        previous = current;
        current = "";
    }

    public void getMult(String newOperator)
    {
        if (current.isEmpty()) {

            JOptionPane.showMessageDialog(jFrame, "Сначала введите число!");
            return;
        }
        if(operator != "*")
        {
            if (!previous.isEmpty()) {
                calculate();
                //previous = current;
                //updateOutput();
            }
        }
        operator = "*";
        if(newOperator == "-")
        {
            current = newOperator;
        }
        //operator = newOperator;
        dop = newOperator;
        if (!previous.isEmpty()) {
            calculate();
        }
        dop = current;
        operator = newOperator;
        previous = current;
        current = "";
    }

    public void getDiv(String newOperator)
    {
        if (current.isEmpty()) {

            JOptionPane.showMessageDialog(jFrame, "Сначала введите число!");
            return;
        }
        if(operator != "/")
        {
            if (!previous.isEmpty()) {
                calculate();
                //previous = current;
                //updateOutput();
            }
        }

        operator = "/";
        if(newOperator == "-")
        {
            current = newOperator;
        }
        //operator = newOperator;
        dop = newOperator;
        if (!previous.isEmpty()) {
            calculate();
        }
        dop = current;
        operator = newOperator;
        previous = current;
        current = "";

    }

    public void getPow(String newOperator)
    {
        if (current.isEmpty()) {

            JOptionPane.showMessageDialog(jFrame, "Сначала введите число!");
            return;
        }
        if(operator != "^")
        {
            if (!previous.isEmpty()) {
                calculate();
                //previous = current;
                //updateOutput();
            }
        }

        operator = "^";
        if(newOperator == "-")
        {
            current = newOperator;
        }
        //operator = newOperator;
        dop = newOperator;
        if (!previous.isEmpty()) {
            calculate();
        }
        dop = current;
        operator = newOperator;
        previous = current;
        current = "";
    }

    public void getSqrt(String newOperator)
    {
        if (current.isEmpty()) {
            JOptionPane.showMessageDialog(jFrame, "Сначала введите число!");
           // current = String.valueOf(result);

            return;
        }
        double num = Double.parseDouble(current);
        if(operator.equals("^"))
        {
            if(num > 0 & num<1)
            {
                JOptionPane.showMessageDialog(jFrame, "Показатель степени должен быть больше 1!");
                flagPow = false;
                operator = null;
                previous = "";
                processOutputNumber();
                return;
            }
        }

        if(num < 0)
        {
            JOptionPane.showMessageDialog(jFrame, "Извлечение корня из отрицательного числа невозможно!");
            return;
        }
        double res = Math.sqrt(num);
        current = String.valueOf(res);
        operator = null;
        previous = "";
        processOutputNumber();
    }

    public void calculate() {
        if (previous.length() < 1 || current.length() < 1) {
            return;
        }


        double result = 0.0;
        double num1 = Double.parseDouble(previous);
        double num2 = Double.parseDouble(current);
        switch (operator) {
            case "*":
                result = num1 * num2;
                flagMult = false;
                break;
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "/":
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(jFrame, "Деление на 0 невозможно!");
                    flagDiv = false;
                    break;
                }
                else {
                    result = num1 / num2;
                    flagDiv = false;
                    break;
                }

            case "^":
                if(num2 > 0 & num2<1)
                {
                    JOptionPane.showMessageDialog(jFrame, "Показатель степени должен быть больше 1!");
                    flagPow = false;
                    break;
                }
                result = Math.pow(num1, num2);
                flagPow = false;
                break;
            default:
                break;
        }
        current = String.valueOf(result);
        operator = null;
        previous = "";
        processOutputNumber();
    }

    class NumberBtnHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton selectedBtn = (JButton) e.getSource();
            for (JButton btn : numbers) {
                if (selectedBtn == btn) {
                    appendToOutput(btn.getText());
                    updateOutput();
                }
            }
            if(selectedBtn == dotjb)
            {
                if (current.isEmpty()) {
                    return;
                }
                else {
                    appendToOutput(dotjb.getText());
                    updateOutput();
                }

            }
            jTextField.requestFocus();
        }

    }

    private class OperatorBtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //boolean flagMult = false;
            JButton selectedBtn = (JButton) e.getSource();
            if (selectedBtn == multjb) {
                flagMult = true;
                getMult(multjb.getText());
                updateOutput2();
            } else if (selectedBtn == addjb) {
                selectOperator(addjb.getText());
                updateOutput2();
            } else if (selectedBtn == subtractjb) {
                selectOperator(subtractjb.getText());
                updateOutput2();
            } else if (selectedBtn == divjb) {
                flagDiv = true;
                getDiv(divjb.getText());
                updateOutput2();
            } else if (selectedBtn == sqrtjb) {
                getSqrt(sqrtjb.getText());
                updateOutput();
            } else if (selectedBtn == powjb) {
                flagPow = true;
                selectOperator(powjb.getText());
                updateOutput2();
            }
            jTextField.requestFocus();

        }
    }

    private class OtherBtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e ) {
            JButton selectedBtn = (JButton) e.getSource();
            if (selectedBtn == deletejb) {
                delete();
            } else if (selectedBtn == clearjb) {
                clear();
            } else if (selectedBtn == equalsjb) {
                calculate();
            }
            updateOutput();
            jTextField.requestFocus();
        }
    }

    public void run()
    {
        jFrame.setVisible(true);
    }

}


