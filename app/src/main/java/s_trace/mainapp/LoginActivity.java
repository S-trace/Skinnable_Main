package s_trace.mainapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {
    // UI references.
    private EditText mLoginView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginView = findViewById(R.id.login);
        mPasswordView = findViewById(R.id.password);

        Button mShowLoginButton = findViewById(R.id.show_login_button);
        mShowLoginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogin();
            }
        });

        Button mShowPasswordButton = findViewById(R.id.show_password_button);
        mShowPasswordButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showPassword();
            }
        });
    }

    private void showLogin() {
        Toast.makeText(this, getString(R.string.login) + mLoginView.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }

    private void showPassword() {
        Toast.makeText(this, getString(R.string.password) + mPasswordView.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }
}
