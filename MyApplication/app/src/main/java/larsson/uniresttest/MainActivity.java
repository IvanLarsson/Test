package larsson.uniresttest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSend;
    private EditText etCat;
    private EditText etCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button)findViewById(R.id.btnSend);
        etCat = (EditText)findViewById(R.id.etCat);
        etCount = (EditText)findViewById(R.id.etCount);

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Context context = getApplicationContext();
                CharSequence text = "Cat: " + etCat.getText()+"\nCount: "+ etCount.getText();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });
    }
}
