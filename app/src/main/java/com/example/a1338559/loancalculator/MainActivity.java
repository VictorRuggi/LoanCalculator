package com.example.a1338559.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etloan, etyears, etint;
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Event handler
    protected void onCalculate(View view)
    {
        int LOAN_AMOUNT = R.id.loan;
        int YEARS = R.id.years;
        double INTEREST_RATE = (double)R.id.interest;

        etloan = (EditText) findViewById(R.id.loan);
        etyears = (EditText) findViewById(R.id.years);
        etint = (EditText) findViewById(R.id.interest);

        //Get Data Input
        String strloan = etloan.getText().toString();
        String stryears = etyears.getText().toString();
        String strint = etint.getText().toString();

        double monthlyPayment;
        double monthlyInterestRate;
        int numberOfPayments;

        if (YEARS != 0 && INTEREST_RATE != 0)
        {
            //calculate the monthly payment
            monthlyInterestRate = INTEREST_RATE / 1200;
            numberOfPayments = YEARS * 12;

            monthlyPayment =
                    (LOAN_AMOUNT * monthlyInterestRate) /
                            (1 - (1 / Math.pow ((1 + monthlyInterestRate), numberOfPayments)));

            monthlyPayment = Math.round (monthlyPayment * 100) / 100.0;
            msg = (TextView) findViewById(R.id.resultBox);
            msg.setVisibility(TextView.VISIBLE);
            msg.setText("Loan_amount: $" + strloan + "\nYears: " + stryears + "\nInterest rate: %" + strint
                    + "\n\nMonthly Payment: $" + monthlyPayment + "\nMonthly Interest rate: %" + monthlyInterestRate +
                    "\nNumber of Payments: " + numberOfPayments);
        }
        else {
            monthlyPayment = 0;
            msg = (TextView) findViewById(R.id.resultBox);
            msg.setVisibility(TextView.VISIBLE);
            msg.setText("Loan_amount: $0" + "\nYears: 0" + "\nInterest rate: %0" +
                    "\n\nMonthly Payment: $0" + "\nMonthly Interest rate: %0" + "\nNumber of Payments: 0");
        }
    }
}
