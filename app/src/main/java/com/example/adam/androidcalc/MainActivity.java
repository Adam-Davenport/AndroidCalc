package com.example.adam.androidcalc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity
{
    private int function;
    private double savedNumber=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //inserts the numbers 0-9
    public void button0(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.append("0");
    }
    public void button1(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.append("1");
    }
    public void button2(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.append("2");
    }
    public void button3(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.append("3");
    }
    public void button4(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.append("4");
    }
    public void button5(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.append("5");
    }
    public void button6(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.append("6");
    }
    public void button7(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.append("7");
    }
    public void button8(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.append("8");
    }
    public void button9(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.append("9");
    }
    //Inserts decimal point if not already present
    public void insertDecimal(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        if(!editText.getText().toString().contains("."))
        {
            if(editText.getText().toString().equals(""))
            {editText.append("0");}

            editText.append(".");
        }
    }
    //Method to consolidate the parsing and saving of numbers
    public void saveNumber()
    {
        try
        {
            EditText editText = (EditText) findViewById(R.id.editText);
            savedNumber = Double.parseDouble(editText.getText().toString());
            editText.setText("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //Saves the current number and prepares the addition function
    public void addition(View view)
    {
        saveNumber();
        function = 1;
    }
    //Saves the current number and prepares the subtraction function
    public void subtraction(View view)
    {
        saveNumber();
        function = 2;
    }
    //Saves the current number and prepares the multiplication function
    public void multiplication(View view)
    {
        saveNumber();
        function = 3;
    }
    //Saves the current number and prepares the division function
    public void division(View view)
    {
        saveNumber();
        function = 4;
    }
    //Performs calculation on the current number
    public void calculation(View view)
    {
        //Importing the text box
        EditText editText = (EditText) findViewById(R.id.editText);
        Double total;
        try
        {
            Double number2 = Double.parseDouble(editText.getText().toString());
            if(function==1)
            {
                total= savedNumber + number2;
            }
            else if(function==2)
            {
                total= savedNumber - number2;
            }
            else if(function==3)
            {
                total= savedNumber * number2;
            }
            else if(function==4)
            {
                total= savedNumber / number2;
            }
            else if(function==5)
            {
                total= savedNumber % number2;

            }
            else
            {
                total = 0.0;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            total = 0.0;
        }
        try
        {
            editText.setText(total.toString());
            function = 0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //Changes the sign by multiplying by -1
    public void changeSign(View view)
    {
        try
        {
            EditText editText = (EditText) findViewById(R.id.editText);
            Double total = currentNumber() * -1;
            editText.setText(total.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //Performs the square root operator on the current number
    public void squareRoot(View view)
    {
        try
        {
            EditText editText = (EditText) findViewById(R.id.editText);
            Double currentNumber = Double.parseDouble(editText.getText().toString());
            Double total= Math.sqrt(currentNumber);
            editText.setText(total.toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    //Performs the modulus operator on the current number
    public void modulus(View view)
    {
        saveNumber();
        function = 5;
    }
    //Clears the display and sets the current saved number to 0
    public void clear(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText("");
        savedNumber = 0;
    }
    //Parses the current number and shows a popup if there is an error
    public double currentNumber()
    {
        try
        {
            EditText editText = (EditText) findViewById(R.id.editText);
            return Double.parseDouble(editText.getText().toString());
        }
        //Displays an error message if an exception is thrown while parsing the number
        catch (Exception e)
        {
            e.printStackTrace();
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("Unable to parse current number! Number set to 0.");
            dialog.setCancelable(true);
            dialog.setPositiveButton("OK",
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = dialog.create();
            alert.show();
            return 0;
        }
    }
}
