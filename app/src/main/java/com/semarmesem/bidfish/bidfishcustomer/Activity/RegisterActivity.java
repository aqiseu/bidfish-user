package com.semarmesem.bidfish.bidfishcustomer.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.semarmesem.bidfish.bidfishcustomer.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegistActivity";


    @BindView(R.id.edt_name_regist)
    EditText edtNameRegist;
    @BindView(R.id.edt_email_regist)
    EditText edtEmailRegist;
    @BindView(R.id.edt_pass_regist)
    EditText edtPassRegist;
    @BindView(R.id.spn_gender)
    Spinner spnGender;
    @BindView(R.id.edt_phone_regist)
    EditText edtPhoneRegist;
    @BindView(R.id.btn_regist)
    Button btnRegist;
    @BindView(R.id.edt_address_regist)
    EditText edtAddressRegist;
    @BindView(R.id.tv_regist_login)
    TextView tvRegistLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        List<String> list = new ArrayList<String>();
        list.add("Female");
        list.add("Male");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnGender.setAdapter(adapter);

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignupPressed();
            }
        });

        tvRegistLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });


    }

    public void onSignupPressed() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        btnRegist.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = edtNameRegist.getText().toString();
        String email = edtEmailRegist.getText().toString();
        String password = edtPassRegist.getText().toString();
        String gender = spnGender.getSelectedItem().toString();
        String address = edtAddressRegist.getText().toString();

        // TODO: Implement your own signup logic here.

        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        btnRegist.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
        Intent register = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(register);
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        btnRegist.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = edtNameRegist.getText().toString();
        String email = edtEmailRegist.getText().toString();
        String password = edtPassRegist.getText().toString();
        String address = edtAddressRegist.getText().toString();
        String phone = edtPhoneRegist.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            edtNameRegist.setError("at least 3 characters");
            valid = false;
        } else {
            edtNameRegist.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmailRegist.setError("enter a valid email address");
            valid = false;
        } else {
            edtEmailRegist.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            edtPassRegist.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            edtPassRegist.setError(null);
        }

        if (address.isEmpty() || address.length() < 4 || address.length() > 40) {
            edtAddressRegist.setError("please enter a valid address");
            valid = false;
        } else {
            edtAddressRegist.setError(null);
        }

        if (phone.isEmpty() || !Patterns.PHONE.matcher(phone).matches()) {
            edtAddressRegist.setError("please enter your phone number");
            valid = false;
        } else {
            edtAddressRegist.setError(null);
        }

        if (spnGender.getSelectedItem().toString().trim().equals(R.string.genderprompt)) {
            TextView errorText = (TextView) spnGender.getSelectedView();
            errorText.setError("not selected yet");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
        }

        return valid;
    }
}
