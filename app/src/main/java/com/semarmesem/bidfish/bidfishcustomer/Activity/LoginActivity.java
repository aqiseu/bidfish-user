package com.semarmesem.bidfish.bidfishcustomer.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.semarmesem.bidfish.bidfishcustomer.MainActivity;
import com.semarmesem.bidfish.bidfishcustomer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_register_button)
    TextView tvRegisterButton;
    String MyPrefs;

    public static final int REQUEST_SIGNUP = 0;
    private static final String TAG = "LoginActivity";
    @BindView(R.id.img_logo_login)
    ImageView imgLogoLogin;
    @BindView(R.id.edt_email_login)
    EditText edtEmailLogin;
    @BindView(R.id.til_email_login)
    TextInputLayout tilEmailLogin;
    @BindView(R.id.edt_pass_login)
    EditText edtPassLogin;
    @BindView(R.id.til_pass_login)
    TextInputLayout tilPassLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        SharedPreferences sp = getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);
        if (!sp.getBoolean("first", false)) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("first", true);
            editor.apply();
            Intent intent = new Intent(this, SliderActivity.class); // Call the AppIntro java class
            startActivity(intent);
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginPressed();
            }
        });

        tvRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(b, REQUEST_SIGNUP);
            }
        });
    }

    public void onLoginPressed() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        btnLogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = edtEmailLogin.getText().toString();
        String password = edtPassLogin.getText().toString();

        // TODO: Implement your own authentication logic here.

        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        btnLogin.setEnabled(true);
        finish();
        Intent login = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(login);
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        btnLogin.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = edtEmailLogin.getText().toString();
        String password = edtPassLogin.getText().toString();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmailLogin.setError("enter a valid email address");
            valid = false;
        } else {
            edtEmailLogin.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            edtPassLogin.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            edtPassLogin.setError(null);
        }

        return valid;
    }
}
