package com.getdefault.task8

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.getdefault.task8.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)

        binding.btnLogin.setOnClickListener {
            login()
        }
        return binding.root
    }

    private fun login() {
        val email = binding.tilEmail.editText?.text.toString()
        val password = binding.tilPassword.editText?.text.toString()
        var isLoginSuccessful = true

        if(emailIsValid(email))
            binding.tilEmail.error = null
        else{
            binding.tilEmail.error = getString(R.string.invalid_email)
            isLoginSuccessful = false
        }

        if(passwordIsValid(password))
            binding.tilPassword.error = null
        else{
            binding.tilPassword.error = getString(R.string.invalid_password)
            isLoginSuccessful = false
        }

        if(isLoginSuccessful)
            Toast.makeText(activity, "Login Success", Toast.LENGTH_SHORT).show()
    }

    private fun passwordIsValid(password: String): Boolean {
        return (password.isNotEmpty() && password.length >= 6)
    }

    private fun emailIsValid(email: String): Boolean {
        return (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches())
    }

}