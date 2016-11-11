package mobi.airberlin;

/*
    This activity will be used for login

 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mobi.airberlin.flightlist.FlightListActivity;

public class MainActivity extends AppCompatActivity {

    Button login;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.login_button);

        context = this;

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FlightListActivity.class);
                startActivity(intent);
            }
        });
    }
}
