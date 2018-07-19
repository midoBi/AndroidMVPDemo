package com.example.mehdi.simpledemomvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mehdi.simpledemomvp.Presenter.LoginPresenter;
import com.example.mehdi.simpledemomvp.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView{

    EditText ed_email;
    EditText ed_password;
    Button mLgin;

    LoginPresenter loginPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_email = findViewById(R.id.email);
        ed_password = findViewById(R.id.password);
        mLgin = findViewById(R.id.login);

        loginPresenter = new LoginPresenter(this);

        // Click Event
        mLgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(ed_email.getText().toString(),ed_password.getText().toString());
            }
        });

    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
