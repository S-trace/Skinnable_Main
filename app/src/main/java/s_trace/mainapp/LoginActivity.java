package s_trace.mainapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
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

        // Initialize SkinResources
        SkinResources.setSkinPackage("s_trace.skin");
        SkinResources.initialize(getApplicationContext());

        // We must inflate layout within skin context
        LayoutInflater li = LayoutInflater.from(SkinResources.getsSkinContext());
        View view = li.inflate(SkinResources.getLayout(R.layout.activity_login), null);
        setContentView(view);

        // And must take layout elements IDs within skin context too (or app will crash during this activity startup)
        mLoginView = findViewById(SkinResources.getIdentifier(R.id.login));
        mPasswordView = findViewById(SkinResources.getIdentifier(R.id.password));

        Button mShowLoginButton = findViewById(SkinResources.getIdentifier(R.id.show_login_button));
        mShowLoginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogin();
            }
        });

        Button mShowPasswordButton = findViewById(SkinResources.getIdentifier(R.id.show_password_button));
        mShowPasswordButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showPassword();
            }
        });
    }

    // Resources which is not present in skin package are loaded from main app package
    private void showLogin() {
        Toast.makeText(this, SkinResources.getString(R.string.login) + mLoginView.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }

    private void showPassword() {
        Toast.makeText(this, SkinResources.getString(R.string.password) + mPasswordView.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }
}
