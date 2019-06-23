package com.codechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private static final double doorsArea = 1.52, windowsArea = 2.40;
    private static final String tintOne = "0,5L", tintTwo = "2,5L", tintThree = "3,6L", tintFour = "18L",
            twoTintFour = "2 latas de 18L", moreThanTintFour = "Mais de duas latas de 18L";
    private double multiplyArea, resultSpins;
    private Spinner spinDoors1, spinDoors2, spinDoors3, spinDoors4, spinWindows1, spinWindows2, spinWindows3,
                    spinWindows4;
    private Integer qtd[] = new Integer[]{0,1,2,3,4,5,6,7,8,9,10};
    private TextView resultTxt, areaTxt;
    private String numberAsString;
    private EditText height1,height2,height3,height4,width1,width2,width3,width4;
    public double h1,h2,h3,h4,w1,w2,w3,w4,result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Doors 1
        spinDoors1 = findViewById(R.id.spinnerDoors1);
        ArrayAdapter<Integer> adapterDoors1 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, qtd);
        spinDoors1.setAdapter(adapterDoors1);

        //Doors 2
        spinDoors2 = findViewById(R.id.spinnerDoors2);
        ArrayAdapter<Integer> adapterDoors2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, qtd);
        spinDoors2.setAdapter(adapterDoors2);

        //Doors 3
        spinDoors3 = findViewById(R.id.spinnerDoors3);
        ArrayAdapter<Integer> adapterDoors3 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, qtd);
        spinDoors3.setAdapter(adapterDoors3);

        //Doors 4
        spinDoors4 = findViewById(R.id.spinnerDoors4);
        ArrayAdapter<Integer> adapterDoors4 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, qtd);
        spinDoors4.setAdapter(adapterDoors4);

        //Windows 1
        spinWindows1 = findViewById(R.id.spinnerWindows1);
        ArrayAdapter<Integer> adapterWindows1 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, qtd);
        spinWindows1.setAdapter(adapterWindows1);

        //Windows 2
        spinWindows2 = findViewById(R.id.spinnerWindows2);
        ArrayAdapter<Integer> adapterWindows2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, qtd);
        spinWindows2.setAdapter(adapterWindows2);

        //Windows 3
        spinWindows3 = findViewById(R.id.spinnerWindows3);
        ArrayAdapter<Integer> adapterWindows3 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, qtd);
        spinWindows3.setAdapter(adapterWindows3);

        //Windows 4
        spinWindows4 = findViewById(R.id.spinnerWindows4);
        ArrayAdapter<Integer> adapterWindows4 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, qtd);
        spinWindows4.setAdapter(adapterWindows4);

        height1 = findViewById(R.id.height1);
        height2 = findViewById(R.id.height2);
        height3 = findViewById(R.id.height3);
        height4 = findViewById(R.id.height4);
        width1  = findViewById(R.id.width1);
        width2  = findViewById(R.id.width2);
        width3  = findViewById(R.id.width3);
        width4  = findViewById(R.id.width4);
        resultTxt  = findViewById(R.id.txtResult);
        areaTxt = findViewById(R.id.txtArea);



    }

    public void calculateBtn(View view) {
        try {
            h1 = Double.parseDouble(height1.getText().toString());
            h2 = Double.parseDouble(height2.getText().toString());
            h3 = Double.parseDouble(height3.getText().toString());
            h4 = Double.parseDouble(height4.getText().toString());

            w1 = Double.parseDouble(width1.getText().toString());
            w2 = Double.parseDouble(width2.getText().toString());
            w3 = Double.parseDouble(width3.getText().toString());
            w4 = Double.parseDouble(width4.getText().toString());
            if (w1 < 1.0 || w2 < 1.0 || w3 < 1.0 || w4 < 1.0
                || h1 > 15.0 || w1 > 15.0  || h2 > 15.0  || w2 > 15.0  || h3 > 15.0  || w3 > 15.0  || h4 > 15.0
                    || w4 > 15.0 ) {
                    Toast.makeText(this, "Digite valores entre 1 e 15 metros!", Toast.LENGTH_LONG).show();
                } else if (h1 < 2.20 || h2 < 2.20 || h3 < 2.20 || h4 < 2.20) {
                    Toast.makeText(this, "A altura da porta deve ter, no mínimo, 2.20 metros!", Toast.LENGTH_LONG).show();
                } else{
                    MathSpins();
                  }
                } catch(NumberFormatException e){
            }
        }

        public void MathSpins(){
            NumberFormat formatter = new DecimalFormat("0.00");
            multiplyArea = (h1 * w1) + (h2 * w2) + (h3 * w3) + (h4 * w4);
            try{
                resultSpins = Double.parseDouble(spinDoors1.getSelectedItem().toString()) * doorsArea;
                resultSpins += Double.parseDouble(spinDoors2.getSelectedItem().toString()) * doorsArea;
                resultSpins += Double.parseDouble(spinDoors3.getSelectedItem().toString()) * doorsArea;
                resultSpins += Double.parseDouble(spinDoors4.getSelectedItem().toString()) * doorsArea;
                resultSpins += Double.parseDouble(spinWindows1.getSelectedItem().toString()) * windowsArea;
                resultSpins += Double.parseDouble(spinWindows2.getSelectedItem().toString()) * windowsArea;
                resultSpins += Double.parseDouble(spinWindows3.getSelectedItem().toString()) * windowsArea;
                resultSpins += Double.parseDouble(spinWindows4.getSelectedItem().toString()) * windowsArea;
                result = multiplyArea - resultSpins;
                formatter.format(result);
                numberAsString = new Double(result).toString();
                areaTxt.setText(numberAsString);

                if(result <= 0){
                    resultTxt.setText("Valores inválidos");
                }else if(result <= 2.50){
                    resultTxt.setText(tintOne);
                }else if(result <= 12.50){
                    resultTxt.setText(tintTwo);
                }else if(result <= 18.00){
                    resultTxt.setText(tintThree);
                }else if(result <= 90.00){
                    resultTxt.setText(tintFour);
                }else if(result <= 180.00){
                    resultTxt.setText(twoTintFour);
                }else {
                    resultTxt.setText(moreThanTintFour);
                }



            }catch(NumberFormatException e){

            }
        }






}
