package com.google.codelabs.mdc.java.shrine;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Fragment representing the login screen for Shrine.
 */
public class LoginFragment extends Fragment {


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.shr_login_fragment, container, false);
        MaterialButton nextButton=view.findViewById(R.id.next_button);
        final TextInputEditText passwordEditText=view.findViewById(R.id.password_text_editText);
        final TextInputLayout passwordInputLayout=view.findViewById(R.id.password_text_input);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPasswordValid(passwordEditText.getText())){
                    passwordInputLayout.setError(null);
                    ( (NavigationHost)  getActivity()).navigateTo(new ProductGridFragment(),
                            false);

                }
                else {
                    passwordInputLayout.setError(getString(R.string.shr_error_password));

                }

            }
        });

       passwordEditText.setOnKeyListener(new View.OnKeyListener() {
           @Override
           public boolean onKey(View view, int i, KeyEvent keyEvent) {

               if(isPasswordValid(passwordEditText.getText())){
                    passwordInputLayout.setError(null);

               }
               return false;
           }
       });



        // Snippet from "Navigate to the next Fragment" section goes here.


        return view;
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
    private boolean isPasswordValid(Editable text)
    {
        return text!=null && text.length()>=8;
    }

}
