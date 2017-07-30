package larsson.uniresttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnSend;
    private EditText etCat;
    private EditText etCount;
    private TextView tvBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button)findViewById(R.id.btnSend);
        etCat = (EditText)findViewById(R.id.etCat);
        etCount = (EditText)findViewById(R.id.etCount);
        tvBox = (TextView)findViewById(R.id.tvBox);

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                tvBox.setText("Cat: " + etCat.getText()+"\nCount: "+ etCount.getText());
            }
        });
    }
}
