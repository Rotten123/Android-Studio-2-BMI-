package com.thishkt.a001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText Height;
    EditText Weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Height = (EditText)findViewById(R.id.editTextTextPersonName);
        Weight = (EditText)findViewById(R.id.editTextTextPersonName2);
        Button submit = (Button)findViewById(R.id.button);

        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                if ( !("".equals(Height.getText().toString())
                        || "".equals(Weight.getText().toString())) )
                {
                    float fh = Float.parseFloat(Height.getEditableText().toString());
                    float fw = Float.parseFloat(Weight.getEditableText().toString());
                    float fresult;
                    TextView result = (TextView)findViewById(R.id.textView05);
                    fh = fh/100;
                    fh = fh*fh;

                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(2);
                    fresult = fw/fh;
                    result.setText(nf.format(fw/fh) +"");
                    TextView dia = (TextView)findViewById(R.id.textView06);

                    if (fresult<18.5)
                        dia.setText("體重過輕");
                    else if (18.5 <= fresult && fresult< 24)
                        dia.setText("正常範圍");
                    else if (24 <=fresult && fresult < 27)
                        dia.setText("過    重");
                    else if (27 <=fresult && fresult < 30)
                        dia.setText("輕度肥胖");
                    else if (30 <= fresult && fresult < 35)
                        dia.setText("中度肥胖");
                    else if (fresult >= 35)
                        dia.setText("重度肥胖        ");
                }
        }
    });
  }
}