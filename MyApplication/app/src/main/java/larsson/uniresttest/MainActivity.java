package larsson.uniresttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button btnSend;
    private EditText etCat;
    private EditText etCount;
    private TextView tvBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button) findViewById(R.id.btnSend);
        etCat = (EditText) findViewById(R.id.etCat);
        etCount = (EditText) findViewById(R.id.etCount);
        tvBox = (TextView) findViewById(R.id.tvBox);

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                tvBox.setText("Cat: " + etCat.getText() + "\nCount: " + etCount.getText());

// Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.super.getApplicationContext());
                String url = "https://andruxnet-random-famous-quotes.p.mashape.com/?cat=famous&count=10";
// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                tvBox.setText("Response is: " + response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvBox.setText("That didn't work!");
                    }

                }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("X-Mashape-Key", "g354Pyc7qGmshYYJNc7vkYBJ6OVYp1jn5lyjsnLI9uam55JQkc");
                        params.put("Accept", "application/json");

                        return params;
                    }
                };
// Add the request to the RequestQueue.
                queue.add(stringRequest);


            }
        });
    }
}
