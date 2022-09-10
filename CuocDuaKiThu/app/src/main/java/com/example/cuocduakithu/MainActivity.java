package com.example.cuocduakithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    ImageButton imb;
    CheckBox cb_1,cb_2,cb_3;
    SeekBar sk_1,sk_2,sk_3;
    int diem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        txtDiem = (TextView) findViewById(R.id.textView_diem);
        cb_1= (CheckBox) findViewById(R.id.checkbox_1);
        cb_2= (CheckBox) findViewById(R.id.checkbox_2);
        cb_3= (CheckBox) findViewById(R.id.checkbox_3);
        sk_1= (SeekBar) findViewById(R.id.searchBar_1);
        sk_2= (SeekBar) findViewById(R.id.searchBar_2);
        sk_3= (SeekBar) findViewById(R.id.searchBar_3);
        imb = (ImageButton) findViewById(R.id.imageButton);

        CountDownTimer countDownTimer = new CountDownTimer(600000, 300) {
            @Override
            public void onTick(long l) {
                int so=5;
                Random random = new Random();
                int so_1 = random.nextInt(so);
                int so_2 = random.nextInt(so);
                int so_3 = random.nextInt(so);

                if(sk_1.getProgress() >= sk_1.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Spuirtle thắng", Toast.LENGTH_LONG).show();
                    imb.setVisibility(View.VISIBLE);
                    if(cb_1.isChecked()){
                        diem +=10;
                    }else{
                        diem -=10;
                    }
                    txtDiem.setText(diem + "");
                }
                if(sk_2.getProgress() >= sk_2.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Lapras thắng", Toast.LENGTH_LONG).show();
                    imb.setVisibility(View.VISIBLE);
                    if(cb_2.isChecked()){
                        diem +=10;
                    }else{
                        diem -=10;
                    }
                    txtDiem.setText(diem + "");
                }
                if(sk_3.getProgress() >= sk_3.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Spuirtle thắng", Toast.LENGTH_LONG).show();
                    imb.setVisibility(View.VISIBLE);
                    if(cb_3.isChecked()){
                        diem +=10;
                    }else{
                        diem -=10;
                    }
                    txtDiem.setText(diem + "");
                }

                sk_1.setProgress(sk_1.getProgress() + so_1);
                sk_2.setProgress(sk_2.getProgress() + so_2);
                sk_3.setProgress(sk_3.getProgress() + so_3);
            }

            @Override
            public void onFinish() {

            }
        };

        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_1.isChecked() || cb_2.isChecked() || cb_3.isChecked()) {
                    sk_1.setProgress(0);
                    sk_2.setProgress(0);
                    sk_3.setProgress(0);
                    imb.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                }else{
                    Toast.makeText(MainActivity.this, "Bạn cần đặt cược trước khi chơi" , Toast.LENGTH_LONG).show();
                }

            }
        });

        cb_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb_2.setChecked(false);
                    cb_3.setChecked(false);
                }
            }
        });
        cb_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
             if(b) {
                 cb_1.setChecked(false);
                 cb_3.setChecked(false);
             }
            }
        });
        cb_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(b) {
                   cb_2.setChecked(false);
                   cb_1.setChecked(false);
               }
            }
        });





















    }
}